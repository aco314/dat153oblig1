package com.example.dat153oblig1;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class AddCardDialogFragment extends DialogFragment {

    ImageView dialogAddImage;
    Button selectCardButton;
    EditText correctAnsInput;
    EditText wrongAns1Input;
    EditText wrongAns2Input;

    static final int SELECT_PICTURE = 1;
    AddCardDialogListener listener;

    public interface AddCardDialogListener {
        void onDialogPositiveClick(QuizCard newCard);
    }

    public AddCardDialogFragment() {}

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater li = LayoutInflater.from(getActivity());
        View view = li.inflate(R.layout.add_card_dialog_fragment, null);
        builder.setView(view);
        builder.setPositiveButton("Add", (dialog, id) -> addPressed())
        //builder.setPositiveButton("Add", (dialog, id) -> listener.onDialogPositiveClick(AddCardDialogFragment.this))
                .setNegativeButton("Cancel", null);

        // For View
        dialogAddImage = (ImageView) view.findViewById(R.id.addCardImage);
        selectCardButton = (Button) view.findViewById(R.id.selectCardButton);
        correctAnsInput = (EditText) view.findViewById(R.id.correctAnsInput);
        wrongAns1Input = (EditText) view.findViewById(R.id.wrongAns1Input);
        wrongAns2Input = (EditText) view.findViewById(R.id.wrongAns2Input);

        selectCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Image picker
                //Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);

            }
        });

        return builder.create();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SELECT_PICTURE && resultCode == Activity.RESULT_OK) {
            Uri selectedImageUri = data.getData();
            if (selectedImageUri != null) {
                dialogAddImage.setImageURI(selectedImageUri);
                dialogAddImage.setTag(selectedImageUri);
                getActivity().getContentResolver().takePersistableUriPermission (selectedImageUri, Intent.FLAG_GRANT_READ_URI_PERMISSION);
            }
        }
    }

    // "Add" button pressed
    private void addPressed() {
        Uri image = (Uri) dialogAddImage.getTag();
        String correct = correctAnsInput.getText().toString();
        String wrong1 = wrongAns1Input.getText().toString();
        String wrong2 = wrongAns2Input.getText().toString();
        QuizCard newCard = new QuizCard(image, correct, wrong1, wrong2);
        listener.onDialogPositiveClick(newCard);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (AddCardDialogListener) context;
    }
}