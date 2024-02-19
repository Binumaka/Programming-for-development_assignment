package Question_6;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Image extends JFrame {

    private JTextField urlTextField;
    private JButton downloadButton;
    private JButton pauseButton;
    private JButton resumeButton;
    private JButton cancelButton;
    private JProgressBar progressBar;
    private JTextArea statusTextArea;
    private ExecutorService executorService;
    private ImageDownloadTask currentTask;

    public Image() {
        setTitle("Image Downloader");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        executorService = Executors.newFixedThreadPool(1); // Only one thread for simplicity
    }

    private void initComponents() {
        urlTextField = new JTextField(30);
        downloadButton = new JButton("Download");
        pauseButton = new JButton("Pause");
        resumeButton = new JButton("Resume");
        cancelButton = new JButton("Cancel");
        progressBar = new JProgressBar(0, 100);
        statusTextArea = new JTextArea(15, 30);
        statusTextArea.setEditable(false);

        downloadButton.addActionListener(e -> {
            String url = urlTextField.getText().trim();
            if (!url.isEmpty() && (currentTask == null || currentTask.isDone())) {
                downloadImage(url);
            } else {
                JOptionPane.showMessageDialog(this, "A download is already in progress.");
            }
        });

        pauseButton.addActionListener(e -> {
            if (currentTask != null) {
                currentTask.pause();
                statusTextArea.append("Download paused.\n");
            }
        });

        resumeButton.addActionListener(e -> {
            if (currentTask != null) {
                currentTask.resume();
                statusTextArea.append("Download resumed.\n");
            }
        });

        cancelButton.addActionListener(e -> {
            if (currentTask != null) {
                currentTask.cancel();
                resetDownload();
                statusTextArea.append("Download canceled.\n");
                currentTask = null; // Reset currentTask
            }
        });

        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(new JLabel("Enter URL:"));
        topPanel.add(urlTextField);
        topPanel.add(downloadButton);
        topPanel.add(pauseButton);
        topPanel.add(resumeButton);
        topPanel.add(cancelButton);
        add(topPanel, BorderLayout.NORTH);

        add(progressBar, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane(statusTextArea);
        scrollPane.setPreferredSize(new Dimension(500, 200));
        add(scrollPane, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    private void downloadImage(String urlString) {
        try {
            progressBar.setValue(0);
            URL url = new URL(urlString);
            currentTask = new ImageDownloadTask(url, statusTextArea, progressBar);
            executorService.submit(currentTask);
        } catch (MalformedURLException e) {
            statusTextArea.append("Invalid URL. Please provide a valid URL.\n");
        }
    }

    private void resetDownload() {
        progressBar.setValue(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Image::new);
    }
}

class ImageDownloadTask implements Runnable {

    private final URL imageUrl;
    private final JTextArea statusTextArea;
    private final JProgressBar progressBar;
    private final AtomicBoolean canceled;
    private final AtomicBoolean paused;

    public ImageDownloadTask(URL imageUrl, JTextArea statusTextArea, JProgressBar progressBar) {
        this.imageUrl = imageUrl;
        this.statusTextArea = statusTextArea;
        this.progressBar = progressBar;
        this.canceled = new AtomicBoolean(false);
        this.paused = new AtomicBoolean(false);
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                if (canceled.get()) {
                    return;
                }

                int progress = i * 10;
                SwingUtilities.invokeLater(() -> {
                    progressBar.setValue(progress);
                    progressBar.setString(progress + "%");
                });

                checkPaused();
                Thread.sleep(500);  // Simulate chunk download time
            }

            SwingUtilities.invokeLater(() -> {
                statusTextArea.append("Downloaded: " + imageUrl.toString() + "\n");
                progressBar.setValue(100);
            });

        } catch (Exception e) {
            SwingUtilities.invokeLater(() -> statusTextArea.append("Error downloading: " + imageUrl.toString() + "\n"));
        }
    }

    private void checkPaused() throws InterruptedException {
        synchronized (this) {
            while (paused.get()) {
                wait();
            }
        }
    }

    public void cancel() {
        canceled.set(true);
    }

    public boolean isDone() {
        return progressBar.getValue() == 100;
    }

    public void pause() {
        paused.set(true);
    }

    public void resume() {
        synchronized (this) {
            paused.set(false);
            notifyAll();
        }
    }
}