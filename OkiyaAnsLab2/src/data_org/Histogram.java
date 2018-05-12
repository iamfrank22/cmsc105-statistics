package data_org;

import java.awt.Color;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

public class Histogram extends JFrame {
	public Histogram(String appTitle, String chartTitle, double[] midpoint, int[] freqCount, int classWidth) {
    super(appTitle);
    CategoryDataset dataset = createDataset(midpoint, freqCount, classWidth);
    JFreeChart chart = createChart(dataset, chartTitle);
    ChartPanel chartPanel = new ChartPanel(chart);
    chartPanel.setPreferredSize(new java.awt.Dimension(500, 300));
    setContentPane(chartPanel);
	}
	
	public static void generateChart(String appTitle, String chartTitle, double[] midpoint, int[] freqCount, int classWidth) {
		Histogram hist = new Histogram(appTitle, chartTitle, midpoint, freqCount, classWidth);
	  hist.pack();
	  hist.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	  RefineryUtilities.centerFrameOnScreen(hist);
	  hist.setVisible(true);
	}
	
	public CategoryDataset createDataset(double[] midpoint, int[] freqCount, int classWidth) {
	    DefaultCategoryDataset result = new DefaultCategoryDataset();
	    for (int i = 0; i < midpoint.length; i++) {
	        result.setValue(freqCount[i], "Midpoint", midpoint[i] + "");
	    }
	    return result;
	}
	
	public JFreeChart createChart(CategoryDataset dataset, String chartTitle) {
	    JFreeChart chart = ChartFactory.createBarChart(chartTitle, "Midpoints", "Frequency", dataset, PlotOrientation.VERTICAL, false, true, true);
	    CategoryPlot plot = chart.getCategoryPlot();
	    plot.setRangeGridlinePaint(Color.BLACK);
	    plot.getDomainAxis().setCategoryMargin(0.0);
	    return chart;
	}

}
