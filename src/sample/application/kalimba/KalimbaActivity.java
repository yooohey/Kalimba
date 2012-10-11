package sample.application.kalimba;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.content.res.TypedArray;

public class KalimbaActivity extends Activity implements OnClickListener{

	private MediaPlayer[] mp;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
    	super.onCreate(savedInstanceState);
        
        setContentView(R.layout.main);
        
        //notes.xml一覧を取得
        TypedArray notes = this.getResources().obtainTypedArray(R.array.notes);
        TypedArray buttons = this.getResources().obtainTypedArray(R.array.buttons);
        
        mp = new MediaPlayer[notes.length()];
        
        for(int i=0; i<notes.length(); i++){
        	mp[i] = MediaPlayer.create(this, notes.getResourceId(i, -1));
        }
        
        for(int i=0; i<buttons.length(); i++){
        	this.findViewById(buttons.getResourceId(i, -1)).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view){
    	
    	TypedArray buttons = this.getResources().obtainTypedArray(R.array.buttons);
    	
    	for(int i=0; i<buttons.length(); i++){
    		if(buttons.getResourceId(i, -1) == view.getId()){
    			mp[i].seekTo(0);
    			mp[i].start();
    			break;
    		}
    	}
    }
    
}
