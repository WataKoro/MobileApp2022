// Generated by view binder compiler. Do not edit!
package com.example.mobapp_widget.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.mobapp_widget.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLoginBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button button2;

  @NonNull
  public final EditText editTextTextPersonName;

  @NonNull
  public final EditText editTextTextPersonName3;

  @NonNull
  public final EditText editTextTextPersonName4;

  @NonNull
  public final EditText editTextTextPersonName5;

  @NonNull
  public final EditText editTextTextPersonName6;

  @NonNull
  public final EditText editTextTextPersonmail;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final ImageView imageView2;

  @NonNull
  public final RadioGroup radioGroup;

  @NonNull
  public final RadioButton rbFemale;

  @NonNull
  public final RadioButton rbMale;

  @NonNull
  public final TextView sapa;

  private ActivityLoginBinding(@NonNull ConstraintLayout rootView, @NonNull Button button2,
      @NonNull EditText editTextTextPersonName, @NonNull EditText editTextTextPersonName3,
      @NonNull EditText editTextTextPersonName4, @NonNull EditText editTextTextPersonName5,
      @NonNull EditText editTextTextPersonName6, @NonNull EditText editTextTextPersonmail,
      @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull RadioGroup radioGroup,
      @NonNull RadioButton rbFemale, @NonNull RadioButton rbMale, @NonNull TextView sapa) {
    this.rootView = rootView;
    this.button2 = button2;
    this.editTextTextPersonName = editTextTextPersonName;
    this.editTextTextPersonName3 = editTextTextPersonName3;
    this.editTextTextPersonName4 = editTextTextPersonName4;
    this.editTextTextPersonName5 = editTextTextPersonName5;
    this.editTextTextPersonName6 = editTextTextPersonName6;
    this.editTextTextPersonmail = editTextTextPersonmail;
    this.imageView = imageView;
    this.imageView2 = imageView2;
    this.radioGroup = radioGroup;
    this.rbFemale = rbFemale;
    this.rbMale = rbMale;
    this.sapa = sapa;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button2;
      Button button2 = ViewBindings.findChildViewById(rootView, id);
      if (button2 == null) {
        break missingId;
      }

      id = R.id.editTextTextPersonName;
      EditText editTextTextPersonName = ViewBindings.findChildViewById(rootView, id);
      if (editTextTextPersonName == null) {
        break missingId;
      }

      id = R.id.editTextTextPersonName3;
      EditText editTextTextPersonName3 = ViewBindings.findChildViewById(rootView, id);
      if (editTextTextPersonName3 == null) {
        break missingId;
      }

      id = R.id.editTextTextPersonName4;
      EditText editTextTextPersonName4 = ViewBindings.findChildViewById(rootView, id);
      if (editTextTextPersonName4 == null) {
        break missingId;
      }

      id = R.id.editTextTextPersonName5;
      EditText editTextTextPersonName5 = ViewBindings.findChildViewById(rootView, id);
      if (editTextTextPersonName5 == null) {
        break missingId;
      }

      id = R.id.editTextTextPersonName6;
      EditText editTextTextPersonName6 = ViewBindings.findChildViewById(rootView, id);
      if (editTextTextPersonName6 == null) {
        break missingId;
      }

      id = R.id.editTextTextPersonmail;
      EditText editTextTextPersonmail = ViewBindings.findChildViewById(rootView, id);
      if (editTextTextPersonmail == null) {
        break missingId;
      }

      id = R.id.imageView;
      ImageView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.imageView2;
      ImageView imageView2 = ViewBindings.findChildViewById(rootView, id);
      if (imageView2 == null) {
        break missingId;
      }

      id = R.id.radioGroup;
      RadioGroup radioGroup = ViewBindings.findChildViewById(rootView, id);
      if (radioGroup == null) {
        break missingId;
      }

      id = R.id.rbFemale;
      RadioButton rbFemale = ViewBindings.findChildViewById(rootView, id);
      if (rbFemale == null) {
        break missingId;
      }

      id = R.id.rbMale;
      RadioButton rbMale = ViewBindings.findChildViewById(rootView, id);
      if (rbMale == null) {
        break missingId;
      }

      id = R.id.sapa;
      TextView sapa = ViewBindings.findChildViewById(rootView, id);
      if (sapa == null) {
        break missingId;
      }

      return new ActivityLoginBinding((ConstraintLayout) rootView, button2, editTextTextPersonName,
          editTextTextPersonName3, editTextTextPersonName4, editTextTextPersonName5,
          editTextTextPersonName6, editTextTextPersonmail, imageView, imageView2, radioGroup,
          rbFemale, rbMale, sapa);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}