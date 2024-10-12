// VideoTabFragment.java
package com.ex// VideoTabFragment.java
package com.example.project00;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.File;

public class VideoTabFragment extends Fragment {

    private VideoView videoView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.video_tab_fragment, container, false);
        videoView = view.findViewById(R.id.videoView);

        // Example video file path (you might need to adjust this based on your download logic)
        String downloadedVideoPath = getDownloadedVideoPath("sample_video.mp4"); // Replace with your downloaded video file name
        playVideo(downloadedVideoPath);

        Button playButton = view.findViewById(R.id.playButton);
        playButton.setOnClickListener(v -> videoView.start());

        Button pauseButton = view.findViewById(R.id.pauseButton);
        pauseButton.setOnClickListener(v -> videoView.pause());

        Button stopButton = view.findViewById(R.id.stopButton);
        stopButton.setOnClickListener(v -> {
            videoView.stopPlayback();
            videoView.resume(); // Resets the video for replay
        });

        return view;
    }

    private String getDownloadedVideoPath(String fileName) {
        // Return the path of the downloaded video file in the Downloads directory
        return new File(android.os.Environment.getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_DOWNLOADS), fileName).getAbsolutePath();
    }

    private void playVideo(String videoPath) {
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
    }
}￼Enter
