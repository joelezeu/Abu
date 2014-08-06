package com.hymn.abu;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class About extends Activity implements OnClickListener{
	
	Button btnEmail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		
		TextView tv = (TextView) findViewById(R.id.textView1);
		tv.setClickable(true);
		tv.setMovementMethod(LinkMovementMethod.getInstance());
		String text = "Developed by <a href=\"www.facebook.com/phatjoe50\">Joel Eze</a>";
		tv.setText(Html.fromHtml(text));
		
		btnEmail = (Button) findViewById(R.id.btnEmail);
		btnEmail.setOnClickListener(new View.OnClickListener() {
	         public void onClick(View view) {
	        	 btnEmail();
	         }

			private void btnEmail() {
				// TODO Auto-generated method stub
				
				Log.i("Send Email to the Develoer","");
			      String[] TO = {"joeltechnologies@gmail.com"};
			      Intent email = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
			      // prompts email clients only
			      email.setType/**("text/plain");**/("message/rfc822");

			      email.putExtra(Intent.EXTRA_EMAIL, new String[]{"joeltechnologies@gmail.com"});
			      email.putExtra(Intent.EXTRA_SUBJECT, "Subject");
			      email.putExtra(Intent.EXTRA_TEXT, "Your message");

			      try {
				    // the user can choose the email client
			         startActivity(Intent.createChooser(email, "Choose an email client"));
			         finish();
			         Log.i("Message Sent", "I will get back to you soonest.");
			      } catch (android.content.ActivityNotFoundException ex) {
			         Toast.makeText(About.this, "No email client installed.",
			        		 Toast.LENGTH_LONG).show();
			      }
				
			}
	   });

		// FullScreen Activity
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		//getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				//WindowManager.LayoutParams.FLAG_FULLSCREEN);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent e = new Intent(this, null);
		startActivity(e);
	}

}
