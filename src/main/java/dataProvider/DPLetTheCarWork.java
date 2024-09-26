package dataProvider;

import dto.LetTheCarDtoLombok;
import org.testng.annotations.DataProvider;
import utils.FuelType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static utils.RandomUtils.*;
import static utils.RandomUtils.generateString;

public class DPLetTheCarWork {

    @DataProvider
    public LetTheCarDtoLombok[] addNewCarDP(){
        LetTheCarDtoLombok car1 = LetTheCarDtoLombok.builder()
                .city("Tel ")
                .manufacture("Toyota")
                .model("Prius.jpg")
                .year("2019")
                .fuel(FuelType.PETROL.getValue())
                .seats(5)
                .carClass("C-class")
                .serialNumber(generateNumber(12))
                .price(1000)
                .about(generateString(20))
                .carPhotoPath("Prius.jpg")
                .build();
        LetTheCarDtoLombok car2 = LetTheCarDtoLombok.builder()
                .city("Tel ")
                .manufacture("Opel")
                .model("Astra")
                .year("2017")
                .fuel(FuelType.GAS.getValue())
                .seats(3)
                .carClass("C-class")
                .serialNumber(generateNumber(12))
                .price(500)
                .about(generateString(20))
                .carPhotoPath("Astra.jpg")
                .build();

        return new LetTheCarDtoLombok[]{car1, car2};
    }

    @DataProvider
    public Iterator<LetTheCarDtoLombok> addNewCarDPFile(){
        List<LetTheCarDtoLombok> carList = new ArrayList<>();
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("src/test/resources/addNewCar.csv"));
            String line = bufferedReader.readLine();
            while (line != null){
                String[] splitArray = line.split(",");
                int seats = Integer.parseInt(splitArray[5]);
                int price = Integer.parseInt(splitArray[8]);
                splitArray[7] = generateNumber(12);
                carList.add(LetTheCarDtoLombok.builder()
                        .city(splitArray[0])
                        .manufacture(splitArray[1])
                        .model(splitArray[2])
                        .year(splitArray[3])
                        .fuel(splitArray[4])
                        .seats(seats)
                        .carClass(splitArray[6])
                        .serialNumber(splitArray[7])
                        .price(price)
                        .about(splitArray[9])
                        .carPhotoPath(splitArray[10])
                        .build());
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return carList.listIterator();
    }
}
