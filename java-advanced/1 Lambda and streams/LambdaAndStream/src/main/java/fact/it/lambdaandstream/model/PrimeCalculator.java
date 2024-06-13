package fact.it.lambdaandstream.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeCalculator {

    public boolean isPrime(int number){
        if(number < 2) return false;

        //Check if there is a divisor of the number in the range of number/2
        for(int i = 2 ;i <= number/2 ; i++){
            if(number % i == 0) return false;
        }
        return true;
    }
    public List<Integer> getListOfAllNumbersUntil(int start, int end){
        return IntStream.rangeClosed(start,end)
                .boxed()
                .collect(Collectors.toList());
    }
    public List<Integer>  getAllPrimesUntil(int number){
        return getListOfAllNumbersUntil(0,number)
                .stream()
                .filter(this::isPrime)
                .collect(Collectors.toList());
    }

}
