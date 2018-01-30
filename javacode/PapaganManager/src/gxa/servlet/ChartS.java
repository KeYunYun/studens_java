package gxa.servlet;

import java.awt.Color;
import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import Conn.Conn;

public class ChartS extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	Conn conn;
	public ChartS() {
		super();
		conn = new Conn();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		StandardChartTheme mChartTheme = new StandardChartTheme("CN");
		mChartTheme.setLargeFont(new Font("黑体", Font.BOLD, 20));
		mChartTheme.setExtraLargeFont(new Font("宋体", Font.PLAIN, 15));
		mChartTheme.setRegularFont(new Font("宋体", Font.PLAIN, 15));
		ChartFactory.setChartTheme(mChartTheme);
		//创建一个图表的数据集，数据来源
		CategoryDataset mDataset = GetDataset();
		//图的类型说明
		JFreeChart mChart = ChartFactory.createLineChart(
				"折线图",
				"年份",
				"数量",
				mDataset,
				PlotOrientation.VERTICAL,
				true, 
				true, 
				false);
		
		CategoryPlot mPlot = (CategoryPlot)mChart.getPlot();
		mPlot.setBackgroundPaint(Color.LIGHT_GRAY);
		mPlot.setRangeGridlinePaint(Color.BLUE);//背景底部横虚线
		mPlot.setOutlinePaint(Color.RED);//边界线
		
//		ChartFrame mChartFrame = new ChartFrame("折线图", mChart);
//		mChartFrame.pack();
//		mChartFrame.setVisible(true);
		//
		 String realPath = request.getRealPath("/upload");
		    String imgname = "line.png";
			OutputStream os = new FileOutputStream(realPath+"\\"+imgname);
			ChartUtilities.writeChartAsPNG(os, mChart, 600, 460);
			request.setAttribute("imgname", imgname);
			os.close();
	
           request.getRequestDispatcher("line.html").forward(request, response);
		
		
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
	public  CategoryDataset GetDataset()
	{
		String sql = 
"select convert(char(4),year(data_time)) + convert(char(1),'-') +convert(varchar(2),month(data_time)) + convert(char(1),'-') + convert(varchar(2),day(data_time)) as '日期', round(avg(value),2) as '平均温度' " +
"from historydata "
+"where channel_name = 1"
+"group by convert(char(4),year(data_time)) + convert(char(1),'-') +convert(varchar(2),month(data_time)) + convert(char(1),'-') + convert(varchar(2),day(data_time))";
		System.out.println(sql);
		ResultSet rs = conn.select(sql);
		DefaultCategoryDataset mDataset = new DefaultCategoryDataset();
		try {
			while(rs.next()){
			 String countdate = rs.getString(1);
			 int countnum = rs.getInt(2);
				mDataset.addValue(countnum, "First", countdate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mDataset;
	}


}
