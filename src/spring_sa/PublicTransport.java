package spring_sa;

public class PublicTransport {
    public static int transNo;

    //주유량
    public int oil = 100;

    //속도
    public int speed = 1;

    //속도 변경

    //최대 승객 수
    static final int TRANS_MAX_PASSENGER = 30;

    public int passenger = 0;


    //있을 경우 (기타 공통 요소들)
    public String state = "운행";

    public PublicTransport() {
        ++transNo;
    }

    //---기능---
    //운행 시작
    public void startRace() {
        if(this.state.equals("운행")) {
            System.out.println("운행을 시작합니다.");
        } else {
            System.out.println("차량 운행을 희망하신다면 스피드를 바꿔주세요.");
        }
    }

    public void changeOil(int oil) {

        this.oil += oil;
        if(this.oil < 10) {
            System.out.println("주유 필요");
        }

        if(this.oil <= 5) {
            changeState();
        }


    }

    //속도 변경
    public void changeSpeed(int speed) {
        if(speed == 0) {
            System.out.println("운행을 중지합니다.");
        } else {
            if(this.oil >= 10) {
                this.speed = speed;
                this.state = "운행";
                startRace();
            } else {
                System.out.println("주유량을 확인해 주세요");
            }
        }


    }

    //상태 변경
    public void changeState() {
        if(this.state.equals("운행") || this.speed <= 0) {
            changeSpeed(0);
            this.state = "차고지행";
        } else {
            changeSpeed(10);
            this.state = "운행";
        }

    }

    //승객 탑승
    public void passengerBoarding(int passenger) {
        this.passenger += passenger;

        if(this.state.equals("운행") && this.passenger + passenger <= TRANS_MAX_PASSENGER) {
            this.passenger += passenger;
        }

        if(this.passenger <= TRANS_MAX_PASSENGER) {
            System.out.println("탑승 승객 수 = " + passenger);
            System.out.println("잔여 승객 수 = " + (TRANS_MAX_PASSENGER - passenger));
        }
        if(this.passenger > TRANS_MAX_PASSENGER){
            this.passenger -= passenger;
            System.out.println("최대 승객 수를 초과했습니다.");
        }
    }
    //있을 경우(기타 공통 기능들)


    //---기본값---
    //주유량 100
    //속도 0

}

class Main {
    public static void main(String[] args) {
        PublicTransport publicTransport1 = new PublicTransport();

        publicTransport1.changeSpeed(100);
        publicTransport1.changeState();
        publicTransport1.passengerBoarding(20);
        publicTransport1.passengerBoarding(20);

        System.out.println(publicTransport1.state);
    }
}
