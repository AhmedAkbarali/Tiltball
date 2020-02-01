package ca.yorku.eecs.mack.demotiltballdelush;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DemoTiltBallResults extends Activity {
    Float  totalTime, inPathTime;
    int totalLaps, wallHits;
    String userData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        Bundle b = getIntent().getExtras();
        totalTime = b.getFloat("totalTime");
        inPathTime = b.getFloat("inPathTime");
        wallHits = b.getInt("wallHits");
        totalLaps = b.getInt("laps");

        TextView tvLaps = (TextView) findViewById(R.id.paramLabelLaps);
        tvLaps.append(Integer.toString(totalLaps));

        TextView tvLapTime = (TextView) findViewById(R.id.paramLabelLapTime);
        tvLapTime.append(String.format("%.2f",(totalTime/totalLaps)) + "s (time/laps)");

        TextView tvWallHits = (TextView) findViewById(R.id.paramLabelWallHits);
        tvWallHits.append(Integer.toString(wallHits));

        TextView tvinPathTime = (TextView) findViewById(R.id.paramLabelInPathTime);
        tvinPathTime.append(String.format("%.2f",(inPathTime/totalTime)*100) + "%");
    }

    /** Called when the "Exit" button is pressed. */
    public void clickExit(View view)
    {
        super.onDestroy(); // cleanup
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void clickSetup(View view)
    {
        Intent i = new Intent(getApplicationContext(),DemoTiltBallSetup.class);
        startActivity(i);
    }
}