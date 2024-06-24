package org.csystem.camera.car.source;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;
import static org.csystem.util.string.StringUtil.*;

class CarFactory {
    private final RandomGenerator m_randomGenerator = new Random();
    private final List<String> RECORDED_PLATES = new ArrayList<String>( );

    {
        RECORDED_PLATES.add("34 CSD 34");
        RECORDED_PLATES.add("67 CSD 67");
        RECORDED_PLATES.add("35 CSD 35");
    }
    private  String createRandomPlateText()
    {
        return String.format("%s%s%s", generateRandomText(m_randomGenerator, 1, "ABCDEFGHIJKLMNPRSTUVYZ"),
                (char)(m_randomGenerator.nextInt(26) + 'A'),
                generateRandomText(m_randomGenerator, 1, "ABCDEFGHIJKLMNPRSTUVYZ"));
    }

    private String getRandomPlate()
    {
        return m_randomGenerator.nextBoolean() ? RECORDED_PLATES.get(m_randomGenerator.nextInt(RECORDED_PLATES.size()))
                : String.format("%02d %s %03d",m_randomGenerator.nextInt(1,82), createRandomPlateText(), m_randomGenerator.nextInt(1000));
    }
    CarCameraInfo createCarCameraInfo()
    {
        return new CarCameraInfo(getRandomPlate(), LocalDateTime.now());
    }

}
