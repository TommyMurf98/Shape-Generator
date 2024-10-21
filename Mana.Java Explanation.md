This Java program uses JavaFX to create a graphical application that allows users to generate and manipulate shapes (polygons). This was submitted as a universtiy assignemnt for the Algorithims & Data Structures module. Here's a breakdown of what the code does:

1. **Packages and Imports**:
   - The program imports several JavaFX libraries such as `Application`, `Stage`, `Scene`, `Circle`, `Polygon`, `TextField`, `Button`, etc., for creating graphical components like shapes and buttons, and for handling user events.

2. **Main Class**:
   - The class `Main` extends `Application`, making it a JavaFX application.
   - The program has several variables:
     - `sidesCount`: Tracks the number of sides for the polygon to be drawn (initially set to 1).
     - `sidesMax`: Sets the maximum number of sides for the polygon (7).
     - `sidesMin`: Sets the minimum number of sides (3).
     - `group`: A `Group` object that holds the graphical components to be displayed.

3. **start() Method**:
   - This is the entry point for the JavaFX application, where the UI is set up.
   - A `VBox` layout is created to hold all components (buttons, text field, and the shape).
   - Initially, a `Circle` is created with specified radius and color to be displayed in the `Group`.
   - A `TextField` is added to allow the user to input the number of sides for the polygon.
   - Three buttons are added:
     - **Generate Shape**: Generates a polygon based on the input in the text field.
     - **Add**: Increases the number of sides and redraws the polygon.
     - **Minus**: Decreases the number of sides and redraws the polygon.
   
4. **Event Handling**:
   - There are several `EventHandler`s set up to respond to button presses:
     - **Generate Shape Button**: Generates a polygon based on the number of sides entered by the user. If the input is valid (between 3 and 7 sides), a polygon is drawn with vertices equally spaced around a circle.
     - **Add Button**: Increases the number of sides, updates the text field, and redraws the polygon.
     - **Minus Button**: Decreases the number of sides, updates the text field, and redraws the polygon.

5. **Shape Drawing Logic**:
   - The method `drawShape(int sides, Group group)` is responsible for drawing the polygon.
   - It calculates the coordinates of the polygon's vertices using trigonometry (each vertex is placed at equal angles around a circle).
   - If the number of sides is valid, the points are added to a `Polygon` object, and the polygon is displayed in the `Group`.
   - The color of the polygon is determined by whether the number of sides is even (blue) or odd (red).

6. **Main Method**:
   - The `main` method simply launches the JavaFX application.

### Key Functionalities:
- Users can input the number of sides (between 3 and 7) to generate different polygons.
- The "Add" and "Minus" buttons allow for dynamically increasing or decreasing the number of sides.
- The polygons are displayed with alternating colors based on the number of sides (even or odd).

In summary, this program provides a simple GUI that lets users create and visualize polygons with varying numbers of sides. The shapes are drawn dynamically based on user input.
