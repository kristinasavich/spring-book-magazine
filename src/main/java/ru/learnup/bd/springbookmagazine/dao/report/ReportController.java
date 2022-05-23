package ru.learnup.bd.springbookmagazine.dao.report;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.learnup.bd.springbookmagazine.dao.activemq.MessageSender;
import ru.learnup.bd.springbookmagazine.dao.controller.usecurity.User;
import ru.learnup.bd.springbookmagazine.dao.controller.usecurity.UserService;
import ru.learnup.bd.springbookmagazine.dao.entity.Buyer;
import ru.learnup.bd.springbookmagazine.dao.repository.BuyRepository;
import ru.learnup.bd.springbookmagazine.dao.repository.BuyerRepository;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/report")
public class ReportController {
    private final UserService userService;
    private final BuyerRepository buyerRepository;
    private final BuyRepository buyRepository;
    private final ReportRepository reportRepository;
    private final ReportViewMapper reportViewMapper;
    private final MessageSender messageSender;

    public ReportController(UserService userService, BuyerRepository buyerRepository, BuyRepository buyRepository, ReportRepository reportRepository, ReportViewMapper reportViewMapper, MessageSender messageSender) {
        this.userService = userService;
        this.buyerRepository = buyerRepository;
        this.buyRepository = buyRepository;
        this.reportRepository = reportRepository;
        this.reportViewMapper = reportViewMapper;
        this.messageSender = messageSender;
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping("/{reportUser}")
    public Boolean getReportByUser(@PathVariable("reportUser") String body){
        User user = userService.loadUserByUsername(SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName());

        Buyer buyer = buyerRepository.findAllByFullNameContains(user.getUsername());
        if(buyer.getFullName() != null) {
            buyRepository.findBuysByIdBuyer(buyer.getId());
           List <Report> reportList = reportRepository.findAllByBuyerContains(buyer.getFullName());
            messageSender.sendMessageList(Collections.singletonList(reportList));
        } else if (user.getRoles().contains("USER_ADMIN")) {

        } else{
            throw new RuntimeException("You haven't made a purchase yet!");
        }

        return true;
    }
}
