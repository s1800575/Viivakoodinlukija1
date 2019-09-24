package com.example.viivakoodinluku1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class KuvausAktiviteetti extends MainActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;
    public String scannedText;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);

    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler((ZXingScannerView.ResultHandler) this);
        mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result rawResult) {

        // näillä näkyy oikein RUN kohdassa
        Log.v(scannedText, rawResult.getText());
        Log.v(scannedText, rawResult.getBarcodeFormat().toString());

      scannedText = rawResult.getText();

      onBackPressed();

    }



}
