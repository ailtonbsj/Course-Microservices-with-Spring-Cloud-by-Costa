package br.ailtonbsj.coursespringcloud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.ailtonbsj.coursespringcloud.exception.UnsuportedMathException;

@RestController
public class MathController {

	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathException("Please set a numeric value!");
		}
		Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
		return sum;
	}
	
	@GetMapping("/subtract/{numberOne}/{numberTwo}")
	public Double subtract(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathException("Please set a numeric value!");
		}
		return convertToDouble(numberOne) - convertToDouble(numberTwo);
	}
	
	@GetMapping("/multiply/{numberOne}/{numberTwo}")
	public Double multiply(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathException("Please set a numeric value!");
		}
		return convertToDouble(numberOne) * convertToDouble(numberTwo);
	}
	
	@GetMapping("/divide/{numberOne}/{numberTwo}")
	public Double divide(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathException("Please set a numeric value!");
		}
		return convertToDouble(numberOne) / convertToDouble(numberTwo);
	}
	
	@GetMapping("/mean/{numberOne}/{numberTwo}")
	public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathException("Please set a numeric value!");
		}
		return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
	}
	
	@GetMapping("/squareroot/{number}")
	public Double squareRoot(@PathVariable("number") String number) throws Exception {
		if(!isNumeric(number)) {
			throw new UnsuportedMathException("Please set a numeric value!");
		}
		return Math.sqrt(convertToDouble(number));
	}

	private Double convertToDouble(String strNumber) {
		if(strNumber == null) return 0D;
		String number = strNumber.replaceAll(",", ".");
		if(isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
}
