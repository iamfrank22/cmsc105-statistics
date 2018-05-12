package data_org;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.RefineryUtilities;

public class PieChart extends JFrame {
	public PieChart(String title, String[] midpoint, double[] vert) {
    super(title);
    setContentPane(createDemoPanel(midpoint, vert, title));
  }

  private static PieDataset createDataset(String[] midpoint, double[] vert) {
    DefaultPieDataset dataset = new DefaultPieDataset();
    for (int i = 0; i < midpoint.length; i++) {
      dataset.setValue(midpoint[i], vert[i]);
    }
    return dataset;
  }

  private static JFreeChart createChart(PieDataset dataset, String title) {
    JFreeChart chart = ChartFactory.createPieChart(
            title,
            dataset,
            true,
            true,
            true);
    return chart;
  }

  public static JPanel createDemoPanel(String[] midpoint, double[] vert, String title) {
    JFreeChart chart = createChart(createDataset(midpoint, vert), title);
    return new ChartPanel(chart);
  }

  public static void generateChart(String[] midpoint, double[] vert, String desc) {
    PieChart chart = new PieChart(desc, midpoint, vert);
    chart.pack();
    chart.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    RefineryUtilities.centerFrameOnScreen(chart);
    chart.setVisible(true);
  }
}
