package org.csystem.app.camera.car;

import com.karandev.io.util.console.Console;
import org.csystem.camera.car.source.CarCameraInfo;
import org.csystem.camera.car.source.CarSource;
import org.csystem.scheduler.CountDownSchedulerEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class CarCameraApp {
    private final Map<String, List<CarCameraInfo>> m_map = new TreeMap<>();
    private CarSource m_carSource;
    private void carInfoCallback(CarCameraInfo carCameraInfo)
    {
        Console.writeLine(carCameraInfo);
        var plate = carCameraInfo.getPlate();

        if (!m_map.containsKey(plate))
            m_map.put(plate, new ArrayList<>());

        m_map.get(plate).add(carCameraInfo);
    }
    public void run(long duration)
    {
        new CountDownSchedulerEx(duration, 1, TimeUnit.SECONDS) {
            private void carCameraCallback(String plate, List<CarCameraInfo> cars)
            {
                Console.writeLine("Plaka : %s", plate);
                cars.forEach(ci -> Console.writeLine("\t%s", ci));
            }
            @Override
            public void onFinish()
            {
                m_carSource.close();
                m_map.keySet().forEach(p -> carCameraCallback(p, m_map.get(p)));
            }
            @Override
            public void onTick(long remainingMilliseconds)
            {

            }
            @Override
            public void onStart()
            {
                m_carSource = new CarSource();
                m_carSource.run(CarCameraApp.this::carInfoCallback);
            }
        }.startScheduler();
    }
}
