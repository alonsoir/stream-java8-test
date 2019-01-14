package com.aironman;

import java.io.IOException;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

public class EmailSenderService {

	public final static boolean sendEmail(String body, String _subject, String _to) {
		
		boolean ret = true;
		Email from = new Email("alonsoir@gmail.com");
		String subject = _subject;
		Email to = new Email(_to);
		Content content = new Content("text/plain", body);
		Mail mail = new Mail(from, subject, to, content);

		SendGrid sg = new SendGrid("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");
		Request request = new Request();
		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			Response response = sg.api(request);
			System.out.println("StatusCode: " + response.getStatusCode());
			System.out.println("response.getBody: " + response.getBody());
			System.out.println("response.getHeaders: " + response.getHeaders());
		} catch (IOException ex) {
			System.out.println(ex.getLocalizedMessage());
			ret = false;
		}
		return ret;
	}
}
