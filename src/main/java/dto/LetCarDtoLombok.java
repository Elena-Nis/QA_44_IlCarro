package dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class LetCarDtoLombok {
    private String city;
    private String manufacture;
    private String model;
    private String year;
    private String fuel;
    private String seats;
    private String carClass;
    private String carRegNumber;
    private String price;
    private String about;
    private String carPhotoPath;
}
