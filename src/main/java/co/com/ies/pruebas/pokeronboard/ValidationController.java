package co.com.ies.pruebas.pokeronboard;

import org.springframework.boot.convert.PeriodUnit;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ValidationController {

    @PostMapping("/poker/validation")
    public ResponseEntity<ResultValidation> validation(@RequestBody RequestValidation requestValidation) {
        return ResponseEntity.ok(new ResultValidation("hand1","HighCard", List.of("As") ));
    }

    public static class RequestValidation implements Serializable {
        public String hand1;
        public String hand2;

        public String getHand1() {
            return hand1;
        }

        public void setHand1(String hand1) {
            this.hand1 = hand1;
        }

        public String getHand2() {
            return hand2;
        }

        public void setHand2(String hand2) {
            this.hand2 = hand2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            RequestValidation that = (RequestValidation) o;

            if (getHand1() != null ? !getHand1().equals(that.getHand1()) : that.getHand1() != null) return false;
            return getHand2() != null ? getHand2().equals(that.getHand2()) : that.getHand2() == null;
        }

        @Override
        public int hashCode() {
            int result = getHand1() != null ? getHand1().hashCode() : 0;
            result = 31 * result + (getHand2() != null ? getHand2().hashCode() : 0);
            return result;
        }
    }

    public static class ResultValidation implements Serializable {
        public String winnerHand;
        public String winnerHandType;

        public List<String> compositionWinnerHand;

        public ResultValidation() {

        }

        public ResultValidation(String winnerHand, String winnerHandType, List<String> compositionWinnerHand) {
            this.winnerHand = winnerHand;
            this.winnerHandType = winnerHandType;
            this.compositionWinnerHand = compositionWinnerHand;
        }

        public String getWinnerHand() {
            return winnerHand;
        }

        public void setWinnerHand(String winnerHand) {
            this.winnerHand = winnerHand;
        }

        public String getWinnerHandType() {
            return winnerHandType;
        }

        public void setWinnerHandType(String winnerHandType) {
            this.winnerHandType = winnerHandType;
        }

        public List<String> getCompositionWinnerHand() {
            return compositionWinnerHand;
        }

        public void setCompositionWinnerHand(List<String> compositionWinnerHand) {
            this.compositionWinnerHand = compositionWinnerHand;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ResultValidation that = (ResultValidation) o;

            if (getWinnerHand() != null ? !getWinnerHand().equals(that.getWinnerHand()) : that.getWinnerHand() != null)
                return false;
            if (getWinnerHandType() != null ? !getWinnerHandType().equals(that.getWinnerHandType()) : that.getWinnerHandType() != null)
                return false;
            return getCompositionWinnerHand() != null ? getCompositionWinnerHand().equals(that.getCompositionWinnerHand()) : that.getCompositionWinnerHand() == null;
        }

        @Override
        public int hashCode() {
            int result = getWinnerHand() != null ? getWinnerHand().hashCode() : 0;
            result = 31 * result + (getWinnerHandType() != null ? getWinnerHandType().hashCode() : 0);
            result = 31 * result + (getCompositionWinnerHand() != null ? getCompositionWinnerHand().hashCode() : 0);
            return result;
        }
    }
}
