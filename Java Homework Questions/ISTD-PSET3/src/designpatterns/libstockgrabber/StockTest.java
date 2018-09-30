package designpatterns.libstockgrabber;




public class StockTest {
    public static void main(String[] args) {
    	StockGrabber IBM = new StockGrabber();
    	StockObserver scott = new StockObserver(IBM,"scott");
    	StockObserver jim = new StockObserver(IBM,"jim");
    	IBM.stockUpdate("IBM going up by $0.05");
    	StockObserver jeremy = new StockObserver(IBM,"jeremy");
    	IBM.stockUpdate("IBM going down by $0.03");

    }






}
