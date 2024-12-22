import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class EarthquakeChart {

    public static void createAndShowChart(Map<Integer, Long> earthquakeData) {
        Map<Integer, Long> sortedEarthquakeData = new TreeMap<>(Collections.reverseOrder());
        sortedEarthquakeData.putAll(earthquakeData);

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<Integer, Long> entry : sortedEarthquakeData.entrySet()) {
            dataset.addValue(entry.getValue(), "Землетрясения", entry.getKey());
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Землетрясения по годам",
                "Год",
                "Кол-во землетрясений",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                true,
                false
        );

        CategoryAxis xAxis = barChart.getCategoryPlot().getDomainAxis();
        xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);

        JFrame frame = new JFrame("Статистика землетрясений");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        ChartPanel chartPanel = new ChartPanel(barChart);
        frame.add(chartPanel);

        frame.setVisible(true);
    }
}
