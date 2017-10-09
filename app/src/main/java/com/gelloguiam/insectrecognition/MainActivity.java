package com.gelloguiam.insectrecognition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    static final int INPUT_SIZE = 299;
    private static final int IMAGE_MEAN = 128;
    private static final float IMAGE_STD = 128;
    private static final String INPUT_NAME = "Mul";
    private static final String OUTPUT_NAME = "final_result";

    private static final String MODEL_FILE = "file:///android_asset/graph.pb";
    private static final String LABEL_FILE = "file:///android_asset/labels.txt";

    static Classifier classifier;
//    static Executor executor = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        initTensorFlowAndLoadModel();
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        cameraView.start();
//    }
//
//    @Override
//    protected void onPause() {
//        cameraView.stop();
//        super.onPause();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        executor.execute(new Runnable() {
//            @Override
//            public void run() {
//                classifier.close();
//            }
//        });
//    }

    private void initTensorFlowAndLoadModel() {
//        executor.execute(new Runnable() {
//            @Override
//            public void run() {
                try {
                    classifier = TensorFlowImageClassifier.create(
                            getAssets(),
                            MODEL_FILE,
                            LABEL_FILE,
                            INPUT_SIZE,
                            IMAGE_MEAN,
                            IMAGE_STD,
                            INPUT_NAME,
                            OUTPUT_NAME);
                    startCameraActivity();
                } catch (final Exception e) {
                    throw new RuntimeException("Error initializing TensorFlow!", e);
                }
            }
//        });
//    }


    private void startCameraActivity() {
        Intent intent = new Intent(this, CameraActivity.class);
        startActivity(intent);
    }

}
