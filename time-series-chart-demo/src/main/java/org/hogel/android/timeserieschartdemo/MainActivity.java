package org.hogel.android.timeserieschartdemo;

import android.app.Activity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.ViewGroup;
import org.hogel.android.timeserieschart.DateLineChartView;
import org.hogel.android.timeserieschart.LineChartStyle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewGroup chartContainer = (ViewGroup) findViewById(R.id.chart_container);

        LineChartStyle lineChartStyle = new LineChartStyle();
        lineChartStyle.setDrawPointCenter(false);
        lineChartStyle.setFrameBorder(new LineChartStyle.Border(LineChartStyle.Border.ALL));
        lineChartStyle.setXLabelFormatter(new LineChartStyle.LabelFormatter() {
            @Override
            public String format(long value) {
                return DateFormat.format("M/d", value).toString();
            }
        });
        DateLineChartView chartView = new DateLineChartView(this, generatePoints(), lineChartStyle);
        chartView.setXGridUnit(2 * 24 * 60 * 60 * 1000);
        chartContainer.addView(chartView);
    }

    private List<DateLineChartView.Point> generatePoints() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        List<DateLineChartView.Point> points = new ArrayList<>();
        try {
            points.add(new DateLineChartView.Point(dateFormat.parse("2014/07/01"), 100));
            points.add(new DateLineChartView.Point(dateFormat.parse("2014/07/02"), 200));
            points.add(new DateLineChartView.Point(dateFormat.parse("2014/07/03"), 400));
            points.add(new DateLineChartView.Point(dateFormat.parse("2014/07/05"), 1100));
            points.add(new DateLineChartView.Point(dateFormat.parse("2014/07/06"), 700));
            points.add(new DateLineChartView.Point(dateFormat.parse("2014/07/08"), 1700));
            points.add(new DateLineChartView.Point(dateFormat.parse("2014/07/09"), 2700));
            points.add(new DateLineChartView.Point(dateFormat.parse("2014/07/10"), 100));
            points.add(new DateLineChartView.Point(dateFormat.parse("2014/07/11"), 1200));
            points.add(new DateLineChartView.Point(dateFormat.parse("2014/07/12"), 1100));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return points;
    }
}
