package lesson20230208.basicprinciples.singleresponsibility;

public class CommonClass {

    public void processRequest() {
        getRequest();
        analyseRequest();
        getDataFromDB();
        prosessDate();
        sendData();
    }

    // ---> Use MVC (Model-View-Controller) pattern instead

    private void sendData() {
    }

    private void prosessDate() {

    }

    private void getDataFromDB() {

    }

    private void analyseRequest() {

    }

    private void getRequest() {

    }


}
