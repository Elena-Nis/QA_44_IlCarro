package dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class LetTheCarDtoLombok {
    private String city;
    private String manufacture;
    private String model;
    private String year;
    private String fuel;
    private int seats;
    private String carClass;
    private String serialNumber;
    private int price;
    private String about;
    private String carPhotoPath;
}
