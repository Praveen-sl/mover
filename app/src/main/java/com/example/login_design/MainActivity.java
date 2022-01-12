package com.example.login_design;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class MainActivity  extends AppCompatActivity{
   CardView card5;
   static final int Sign_in = 0;
   private GoogleSignInClient mGoogleSignInClient;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      card5 = findViewById(R.id.card5);

      GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
              .requestEmail()
              .build();

      mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

     card5.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            switch (view.getId()) {
               case R.id.card5:
                  signin();
                  break;
            }
         }
      });
   }

   private void signin() {
      Intent signInIntent = mGoogleSignInClient.getSignInIntent();
      startActivityForResult(signInIntent, Sign_in);
   }
   @Override
   public void onActivityResult(int requestCode, int resultCode, Intent data) {
      super.onActivityResult(requestCode, resultCode, data);

      // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
      if (requestCode == Sign_in) {
         // The Task returned from this call is always completed, no need to attach
         // a listener.
         Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
         handleSignInResult(task);
      }
   }
   private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
      try {
         GoogleSignInAccount account = completedTask.getResult(ApiException.class);

         // Signed in successfully, show authenticated UI.
         Toast.makeText(this, "Sign in Successful", Toast.LENGTH_SHORT).show();
         Intent intent = new Intent(this,ListActivity.class);
         startActivity(intent);
      } catch (ApiException e) {
         // The ApiException status code indicates the detailed failure reason.
         // Please refer to the GoogleSignInStatusCodes class reference for more information.
         Log.w("Error", "signInResult:failed code=" + e.getStatusCode());

      }
   }
}
