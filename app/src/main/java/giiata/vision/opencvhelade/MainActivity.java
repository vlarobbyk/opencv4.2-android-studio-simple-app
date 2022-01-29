package giiata.vision.opencvhelade;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import giiata.vision.opencvhelade.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Bitmap bitmapI;
    private Bitmap bitmapO;
    private android.widget.ImageView imgView;
    private android.widget.ImageView imgView2;

    private android.widget.SeekBar seekBarHMin;
    private android.widget.SeekBar seekBarSMin;
    private android.widget.SeekBar seekBarVMin;

    private android.widget.SeekBar seekBarHMax;
    private android.widget.SeekBar seekBarSMax;
    private android.widget.SeekBar seekBarVMax;

    // Used to load the 'opencvhelade' library on application startup.
    static {
        System.loadLibrary("opencvhelade");
    }


    private void applyFilter(){
        filters(bitmapI,bitmapO,seekBarHMin.getProgress(),seekBarSMin.getProgress(),seekBarVMin.getProgress(),
                seekBarHMax.getProgress(),seekBarSMax.getProgress(),seekBarVMax.getProgress());
        imgView2.setImageBitmap(bitmapO);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        bitmapI = BitmapFactory.decodeResource(getResources(),R.drawable.catedral_san_basilio);
        bitmapO = bitmapI.copy(bitmapI.getConfig(),true);

        imgView = findViewById(R.id.imageView);
        imgView2 = findViewById(R.id.imageView2);
        imgView.setImageBitmap(bitmapI);
        imgView2.setImageBitmap(bitmapO);


        seekBarHMin = findViewById(R.id.sbHMin);
        seekBarSMin = findViewById(R.id.sbSMin);
        seekBarVMin = findViewById(R.id.sbVMin);

        seekBarHMax = findViewById(R.id.sbHMax);
        seekBarSMax = findViewById(R.id.sbSMax);
        seekBarVMax = findViewById(R.id.sbVMax);

        seekBarHMin.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                applyFilter();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarSMin.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                applyFilter();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarVMin.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                applyFilter();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarHMax.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                applyFilter();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarSMax.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                applyFilter();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarVMax.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                applyFilter();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        applyFilter();

    }

    /**
     * A native method that is implemented by the 'opencvhelade' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    public native void filters(Bitmap bitmapIn, Bitmap bitmapOut, int hMin, int sMin, int vMin, int hMax, int sMax, int vMax);
}