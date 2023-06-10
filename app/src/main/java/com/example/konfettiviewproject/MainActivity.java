package com.example.konfettiviewproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.model.Circle;

import java.util.concurrent.TimeUnit;

import nl.dionsegijn.konfetti.core.Party;
import nl.dionsegijn.konfetti.core.PartyFactory;
import nl.dionsegijn.konfetti.core.Position;
import nl.dionsegijn.konfetti.core.emitter.Emitter;
import nl.dionsegijn.konfetti.core.emitter.EmitterConfig;
import nl.dionsegijn.konfetti.core.models.Shape;
import nl.dionsegijn.konfetti.core.models.Size;
import nl.dionsegijn.konfetti.xml.KonfettiView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        KonfettiView konfettiView = findViewById(R.id.konfettiView);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EmitterConfig emitterConfig = new Emitter(300, TimeUnit.MILLISECONDS).max(300);
                konfettiView.start(new PartyFactory(emitterConfig).
                        shapes(Shape.Circle.INSTANCE,Shape.Square.INSTANCE).
                        spread(1000).position(0.5,0.25,1,1)
                        .sizes(new Size(8,50,10))
                        .timeToLive(10000).fadeOutEnabled(true).build()

                );


            }
        });

    }


}