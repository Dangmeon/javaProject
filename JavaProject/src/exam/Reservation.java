package exam;

public class Reservation {

    private String flight;    
    private String name;        
    private String departure;   // 출발지
    private String destination;  // 도착지
    private int price;          
    private String seat;        
	
    public Reservation(String flight, String name, String departure, String destination, int price, String seat) {
        this.flight = flight;
        this.name = name;
        this.departure = departure;
        this.destination = destination;
        this.price = price;
        this.seat = seat;
    }
    
    void showRsvInfo() {
        System.out.println("**항공권 예약 정보**");
        System.out.println("항공기 : " + this.flight);
        System.out.println("예약자 : " + this.name);
        System.out.println("출발지 : " + this.departure);
        System.out.println("도착지 : " + this.destination);
        System.out.println("금액 : " + this.price);
        System.out.println("좌석번호 : " + this.seat);
    }
    
}
