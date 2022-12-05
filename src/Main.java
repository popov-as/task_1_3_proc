import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        final int PART_COUNT = 8;

        float smallRadius = readRadius("малой");
        float bigRadius = readRadius("большой");

        float smallCircleArea = getCircleArea(smallRadius);
        float bigCircleArea = getCircleArea(bigRadius);
        float squareArea = getSquareArea(2 * bigRadius);

        float pieArea = smallCircleArea / PART_COUNT;                        // Площадь внутреннего куска пирога
        float segmentArea = (bigCircleArea - smallCircleArea) / PART_COUNT;  // Площадь сегмента между большим и малым кругом
        float cornerArea = (squareArea - bigCircleArea) / PART_COUNT;        // Площадь угла квадрата вне круга

        float areaOfPicture1 = getArea(pieArea, segmentArea, cornerArea, 3, 0, 4);
        float areaOfPicture2 = getArea(pieArea, segmentArea, cornerArea, 6, 1, 1);
        float areaOfPicture3 = getArea(pieArea, segmentArea, cornerArea, 2, 6, 2);

        printArea("1", areaOfPicture1);
        printArea("2", areaOfPicture2);
        printArea("3", areaOfPicture3);
    }

    private static float getCircleArea(float radius)
    {
        return (float) Math.PI * radius * radius;
    }

    private static float getSquareArea(float side)
    {
        return side * side;
    }

    private static float getArea(float pieArea, float segmentArea, float cornerArea, int pieCount, int segmentCount, int cornerCount)
    {
        return pieArea * pieCount + segmentArea * segmentCount + cornerArea * cornerCount;
    }

    private static float readRadius(String circleName)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Введите радиус %s окружности: ", circleName);
        float side = scanner.nextFloat();

        if (side <= 0) throw new RuntimeException("Радиус должен быть больше нуля");

        return side;
    }

    private static void printArea(String pictureName, float area)
    {
        System.out.printf("Площадь фигуры на рис. %s: %.3f\n", pictureName, area);
    }
}