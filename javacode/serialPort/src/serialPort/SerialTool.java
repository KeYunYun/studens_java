package serialPort;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.TooManyListenersException;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;

public class SerialTool {
	
	private static SerialTool serialtool=null;
	
	static{
		//在该类被ClassLoader加载时就初始化一个SerialTool对象
		if(serialtool ==null){
			serialtool =new SerialTool();
		}
	}
	/**
	 * 私有化SerialTool的构造方法
	 * 不允许其他类生成该方法
	 */
	private SerialTool(){
		
	}
	
	/**
	 * 获取提供服务的SerialTool对象
	 */
	public static SerialTool getSerialTool(){
		if(serialtool ==null){
			serialtool=new SerialTool();
		}	
		return serialtool;
		
	}
	
	
	/**
	 * 查找所有可用的端口号
	 */
	public static final ArrayList<String> findPort(){
		//获得当前所有可用的串口
		Enumeration<CommPortIdentifier> portList =
				CommPortIdentifier.getPortIdentifiers()	;
		ArrayList<String> portNameList=new ArrayList<String>();
		
		//将可用串口名添加到List并返回该List
		while(portList.hasMoreElements()){
			String portName=portList.nextElement().getName();
			portNameList.add(portName);
			
		}
		return portNameList;
	}
	
	/**
	 * 打开串口
	 * portName  端口名称
	 * baudrate  波特率
	 * @throws PortInUseException 
	 * @throws NoSuchPortException 
	 * 
	 */
	public static final SerialPort openPort(String portName,
			int baudrate) throws PortInUseException, NoSuchPortException
	{
		
	            // 通过端口名识别端口
	            CommPortIdentifier portIdentifier = CommPortIdentifier
	                    .getPortIdentifier(portName);
	            // 打开端口，设置端口名与timeout（打开操作的超时时间）
	            CommPort commPort = portIdentifier.open(portName, 2000);
	            // 判断是不是串口
	            if (commPort instanceof SerialPort) {
	                SerialPort serialPort = (SerialPort) commPort;
	                
	                    // 设置串口的波特率等参数
	                    try {
							serialPort.setSerialPortParams(baudrate,
							        SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
							        SerialPort.PARITY_NONE);
						} catch (UnsupportedCommOperationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	               
	                return serialPort;
	        
	            }else{
				return null;
				}
	}
	
	/**
	 * 关闭串口
	 * 
	 */
    public static void closePort(SerialPort serialPort) {
        if (serialPort != null) {
            serialPort.close();
            serialPort = null;
        }
    }
    /**
     * 往串口发送数据
     * @param serialPort 串口对象
     * @param order    待发送数据
    
     */
    public static void sendToPort(SerialPort serialPort, byte[] order) {

        OutputStream out = null;
        
        try {
            
            out = serialPort.getOutputStream();
            out.write(order);
            out.flush();
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                    out = null;
                }                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }
    
    /**
     * 从串口读取数据
     * @param serialPort 当前已建立连接的SerialPort对象
     * @return 读取到的数据
     * @throws ReadDataFromSerialPortFailure 从串口读取数据时出错
     * @throws SerialPortInputStreamCloseFailure 关闭串口对象输入流出错
     */
    public static byte[] readFromPort(SerialPort serialPort)  {

        InputStream in = null;
        byte[] bytes = null;

        try {
            
            in = serialPort.getInputStream();
            int bufflenth = in.available();        //获取buffer里的数据长度
            
            while (bufflenth != 0) {                             
                bytes = new byte[bufflenth];    //初始化byte数组为buffer中数据的长度
                in.read(bytes);
                bufflenth = in.available();
            } 
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                    in = null;
                }
            } catch(IOException e) {
                e.printStackTrace();
            }

        }

        return bytes;

    }
    
    /**
     * 添加监听器
     * @param port     串口对象
     * @param listener 串口监听器
     * @throws TooManyListeners 监听类对象过多
     */
    public static void addListener(SerialPort port, SerialPortEventListener listener) {

        try {
            
            //给串口添加监听器
            port.addEventListener(listener);
            //设置当有数据到达时唤醒监听接收线程
            port.notifyOnDataAvailable(true);
          //设置当通信中断时唤醒中断线程
            port.notifyOnBreakInterrupt(true);

        } catch (TooManyListenersException e) {
            e.printStackTrace();
        }
    }
}