package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.ImageReader;
import com.javarush.task.task16.task1631.common.ImageTypes;
import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {

    public static ImageReader getImageReader(ImageTypes types) {

            if (ImageTypes.JPG.equals(types))
                return new JpgReader();
            else if (ImageTypes.BMP.equals(types))
                return new BmpReader();
            else if (ImageTypes.PNG.equals(types))
                return new PngReader();
            else throw new IllegalArgumentException ("Неизвестный тип картинки");

    }

}
