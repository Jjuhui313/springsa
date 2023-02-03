package spring_sa;

public class Bus extends PublicTransport {
    public static final int MAX_PASSENGER = 30;

    public int passenger = 0;

    public int pay = 0;

    public int plusPay = 1000;


    public String state = "운행";

    public Bus() {
        super();
        System.out.println(transNo + "번 버스객체 만들어짐!");
    }

    @Override
    public void changeState() {
        if(this.state.equals("운행") || this.speed <= 0) {
            this.state = "차고지행";
        } else {
            this.state = "운행";
        }
    }

    @Override
    public void passengerBoarding(int passenger) {
        this.passenger += passenger;

        if(this.state.equals("운행") && (this.passenger + passenger) <= MAX_PASSENGER) {
            this.passenger = passenger;
        }
        if(this.passenger <= MAX_PASSENGER) {
            System.out.println("탑승 승객 수 = " + passenger);
            System.out.println("잔여 승객 수 = " + (MAX_PASSENGER - passenger));
            System.out.println("요금 = " + plusPay * passenger);
            this.pay += plusPay;
        }


        if(this.passenger > MAX_PASSENGER){
            this.passenger -= passenger;
            System.out.println("최대 승객 수를 초과했습니다.");
        }
    }


}

class busTest {
    public static void main(String[] args) {
        Bus bus1 = new Bus();
        Bus bus2 = new Bus();
        bus1.passengerBoarding(2);

        bus1.changeOil(-50);
        System.out.println("주유량: " + bus1.oil);

        bus1.changeState();
        System.out.println("상태: " + bus1.state);

        bus1.changeOil(10);
        System.out.println("주유량: " + bus1.oil);
        bus1.changeState();

        bus1.passengerBoarding(45);

        bus1.passengerBoarding(5);

        bus1.changeOil(-55);
        System.out.println("주유량: " + bus1.oil);
        System.out.println("상태: " + bus1.state);



    }
}
