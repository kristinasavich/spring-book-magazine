package ru.learnup.bd.springbookmagazine.dao.report;

import org.springframework.stereotype.Component;

@Component
public class ReportViewMapper {
    public ReportView mapToView(Report report){
        ReportView reportView = new ReportView();
        reportView.setAmountBook(report.getAmountBook());
        reportView.setId(report.getId());
        reportView.setBuyer(report.getBuyer());
        reportView.setDate(report.getDate());
        reportView.setSum(report.getSum());
        return reportView;
    }

    public Report mapFromView(ReportView reportView){
        Report report = new Report();
        report.setAmountBook(reportView.getAmountBook());
        report.setBuyer(reportView.getBuyer());
        report.setDate(reportView.getDate());
        report.setSum(reportView.getSum());
        report.setId(reportView.getId());
        return report;
    }
}
