package net.simplifiedlearning.firebaseauth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class UpdateProfileActivity extends AppCompatActivity {

    private EditText edtNickname;
    private TextView tvEmail;
    private EditText edtGender;
    private EditText edtBirthday;
    private EditText edtAddress;
    private EditText edtPhone;
    private ImageView imgEditNickname;
    private ImageView imgEditGender;
    private ImageView imgEditBirthday;
    private ImageView imgEditPhone;
    private ImageView imgEditAddress;
    private FirebaseAuth mAuth;
    private DatabaseReference mData;
    private Button btnSaveChanges;
    boolean check  = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        mAuth = FirebaseAuth.getInstance();
        mData = FirebaseDatabase.getInstance().getReference();

        AnhXa();

        final String email = mAuth.getCurrentUser().getEmail();
        tvEmail.setText(email);

        Intent intent = getIntent();
        final User user = (User) intent.getSerializableExtra("userProfile");

        if (user!=null){
            String getName = user.getNicknameUser();
            String getGender = user.getGenderUser();
            String getBirthday = user.getBirthDayUser();
            String getPhone = user.getPhoneNumberUser();
            String getAddress = user.getAddressUser();
            if ( !getName.equals("")){
                edtNickname.setText(getName);
            }else{
                edtNickname.setHint("Unavailable");
            }
            if ( !getGender.equals("")){
                edtGender.setText(getGender);
            }else{
                edtGender.setHint("Unavailable");
            }
            if ( !getBirthday.equals("")){
                edtBirthday.setText(getBirthday);
            }else{
                edtBirthday.setHint("Unavailable");
            }
            if ( !getPhone.equals("")){
                edtPhone.setText(getPhone);
            }else{
                edtPhone.setHint("Unavailable");
            }
            if ( !getAddress.equals("")){
                edtAddress.setText(getAddress);
            }else{
                edtAddress.setHint("Unavailable");
            }
        }


        btnSaveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtNickname.getText().toString();
                String gender = edtGender.getText().toString();
                String birthday = edtBirthday.getText().toString();
                String phone = edtPhone.getText().toString();
                String address = edtAddress.getText().toString();
                if ( !name.equals("")){
                    edtNickname.setText(name);
                }else{
                    edtNickname.setText("Unavailable");
                }
                if ( !gender.equals("")){
                    edtGender.setText(gender);
                }else{
                    edtGender.setText("Unavailable");
                }
                if ( !birthday.equals("")){
                    edtBirthday.setText(birthday);
                }else{
                    edtBirthday.setText("Unavailable");
                }
                if ( !phone.equals("")){
                    edtPhone.setText(phone);
                }else{
                    edtPhone.setText("Unavailable");
                }
                if ( !address.equals("")){
                    edtAddress.setText(address);
                }else{
                    edtAddress.setText("Unavailable");
                }

                User user1 = user;

                if (user!=null){
                    user1 = new User(user.getIdUser(),email,name,user.getLinkAvatarUser(),birthday,gender,phone,address);
                    mData.child("UserProfile").child(user.getIdUser()).setValue(user1);
                    Toast.makeText(UpdateProfileActivity.this, "Update", Toast.LENGTH_SHORT).show();
                    check = false;
                }else{
                    Calendar calendar = Calendar.getInstance();
                    String time = String.valueOf(calendar.getTimeInMillis());
                    user1 = new User(time,email,name,"",birthday,gender,phone,address);
                    mData.child("UserProfile").child(time).setValue(user1);
                    check = true;
                    Toast.makeText(UpdateProfileActivity.this, "Create", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(UpdateProfileActivity.this, Profile2Activity.class);
                intent.putExtra("userUpdate",user1);
                startActivity(intent);

            }
        });

    }

//    private void loadData(final String email) {
//        mData.child("UserProfile").addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                User getUser = dataSnapshot.getValue(User.class);
//                if ( getUser.getEmailUser().equals(email)){
//                    currentUser = getUser;
//                    check = true;
//                    Toast.makeText(UpdateProfileActivity.this, "Found", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//        Toast.makeText(UpdateProfileActivity.this, "Not found", Toast.LENGTH_SHORT).show();
//    }

    private void AnhXa() {
        edtNickname = findViewById(R.id.edtUpdateUsernameUser);
        tvEmail = findViewById(R.id.tvEmail);
        edtGender = findViewById(R.id.edtUpdateGenderUser);
        edtBirthday = findViewById(R.id.edtUpdateBirthdayUser);
        edtPhone = findViewById(R.id.edtUpdatePhoneNumberUser);
        edtAddress = findViewById(R.id.edtUpdateAddressUser);
        imgEditNickname = findViewById(R.id.imgEditUsernameUser);
        imgEditGender = findViewById(R.id.imgEditGenderUser);
        imgEditBirthday = findViewById(R.id.imgEditBirthdayUser);
        imgEditPhone = findViewById(R.id.imgEditPhoneNumberUser);
        imgEditAddress = findViewById(R.id.imgEditAddressUser);
        btnSaveChanges = findViewById(R.id.btnSaveChanges);
    }
}
