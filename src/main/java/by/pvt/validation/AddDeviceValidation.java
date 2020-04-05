package by.pvt.validation;

import by.pvt.pojo.device.Device;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class AddDeviceValidation implements Validator{

        public boolean supports(Class<?> clazz) {
            return Device.class.equals(clazz);
        }

        @Override
        public void validate(Object target, Errors errors) {
            Device device = (Device) target;
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "deviceName", "field.required",
                    "Device name must not be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "deviceType", "field.required",
                    "Please choose device type");
            if (device.getDeviceName().length()<=3) {
                errors.rejectValue("device", "deviceName.length",
                        "Device name must be more than 3");
            }
        }
}
