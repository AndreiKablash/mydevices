package by.pvt.validation;

import by.pvt.pojo.device.Device;
import by.pvt.pojo.device.Sensor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class AddDeviceSensorValidation implements Validator {

        public boolean supports(Class<?> clazz) {
            return Device.class.equals(clazz);
        }

        @Override
        public void validate(Object target, Errors errors) {
            Sensor sensor = (Sensor) target;
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sensorName", "field.required",
                    "Sensor name must not be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sensorType", "field.required",
                    "Please choose sensor type");
            if (sensor.getSensorName().length()<=3) {
                errors.rejectValue("sensor", "sensorName.length",
                        "Sensor name must be more than 3");
            }
        }

}
