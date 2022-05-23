package ru.learnup.bd.springbookmagazine.dao.report;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ReportService {
    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public void createReport(Report report) {
        report.setDate(System.currentTimeMillis());
        reportRepository.save(report);

    }

    public List<Report> getReportPerMonth(String buyer) throws ParseException {
        long l = (System.currentTimeMillis()) / 1000 / 60 / 60 / 24 * 30;
        List<Report> allByBuyerContains = reportRepository.findAllByBuyerContains(buyer);
        List<Report> reportPerMonth = new ArrayList<>();
        for (Report a : allByBuyerContains) {
            if (a.getDate() < l) {
                reportPerMonth.add(a);
            }
        }
        return reportPerMonth;
    }
}


//    String myDate = "2014/10/29 18:10:45";
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//    Date date = sdf.parse(myDate);
//    long millis = date.getTime();

//    LocalDate localDate = LocalDate.now(ZoneId.of("Europe/Moscow")).minus(Period.ofDays(30));
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//    localDate.format(formatter);
//}
//}
