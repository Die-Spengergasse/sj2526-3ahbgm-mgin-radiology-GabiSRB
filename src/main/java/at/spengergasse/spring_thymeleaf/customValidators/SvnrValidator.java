package at.spengergasse.spring_thymeleaf.customValidators;

import at.spengergasse.spring_thymeleaf.customAnnotations.ValidSVNR;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SvnrValidator implements ConstraintValidator<ValidSVNR, String> {
    @Override
    public boolean isValid(String svnr, ConstraintValidatorContext context) {
            if (svnr == null || !svnr.matches("\\d{10}")) {
                return false;
            }

            int[] weights = {3, 7, 9, 5, 8, 4, 2, 1, 6};

            int sum = 0;

            // alle außer der 4. Ziffer (Index 3!)
            int weightIndex = 0;

            for (int i = 0; i < 10; i++) {
                if (i == 3) continue; // Prüfziffer überspringen

                int digit = svnr.charAt(i) - '0';
                sum += digit * weights[weightIndex];
                weightIndex++;
            }

            int calculatedCheckDigit = sum % 11;

            // wenn 10 rauskommt → ungültig
            if (calculatedCheckDigit == 10) {
                return false;
            }

            int actualCheckDigit = svnr.charAt(3) - '0'; // 4. Stelle

            return calculatedCheckDigit == actualCheckDigit;

    }
}
