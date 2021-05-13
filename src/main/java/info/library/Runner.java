package info.library;

import info.library.application.Application;
import info.library.service.*;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) {
        ApplicationService service = new ApplicationServiceImpl();
//        try {
//            FillingDatabase.fillIn();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Application.start(service);
    }
}
