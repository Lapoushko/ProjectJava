package Report;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import java.nio.file.Path;
import java.nio.file.Paths;

class ReportChart {
    private final int imageHeight;
    private final boolean excludeWithZeroScore;
    private final Path chartsSavePath;

    public ReportChart(
            int imagesHeight,
            String chartsSavePath,
            boolean excludeWithZeroScore
    ) {
        this.imageHeight = imagesHeight;
        this.excludeWithZeroScore = excludeWithZeroScore;
        this.chartsSavePath = Paths.get(chartsSavePath).toAbsolutePath();
    }
}