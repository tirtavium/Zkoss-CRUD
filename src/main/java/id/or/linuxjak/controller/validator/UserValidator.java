package id.or.linuxjak.controller.validator;

import java.util.Map;

import org.zkoss.bind.Property;
import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.validator.AbstractValidator;

public class UserValidator extends AbstractValidator {

	@Override
	public void validate(ValidationContext ctx) {
		// TODO Auto-generated method stub
		Map<String,Property> beanProps = ctx.getProperties(ctx.getProperty().getBase());
		
		validatePassword(ctx, (String)beanProps.get("password").getValue(), (String)beanProps.get("passwordConfirm").getValue());
	}
	 private void validatePassword(ValidationContext ctx, String password,String confrimPassword) {
		 if(password == null || confrimPassword == null){
			 this.addInvalidMessage(ctx, "passwordMatch", "Password can't null");

		 }else if(!password.equals(confrimPassword)) {
	        	 this.addInvalidMessage(ctx, "passwordMatch", "Password must match");
	        }
	    }
}
