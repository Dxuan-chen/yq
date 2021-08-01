package homework.test16;

import java.io.File;
import java.io.FileFilter;

/**
 *
 */
public class JavaFilter implements FileFilter {
    @Override
    public boolean accept(File pathname) {

        return pathname.getName().endsWith(".java");
    }
}
