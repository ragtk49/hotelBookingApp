# WanderInn - hotel booking app

WanderInn is a hotel booking application that allows users to find and book hotels and rooms for their travels. This project is built using React for the frontend and Spring Boot with MongoDB for the backend.

## Features

- User Registration and Login: Users can create an account and log in to the application to access their bookings and profile.
- Hotel and Room Listings: Browse through a list of hotels and their available rooms for booking.
- Hotel Search and Filter: Search for hotels based on location, price, rating, and amenities.
- Room Availability: Check room availability and book rooms for specific dates.
- User Profile: Users can view and update their profile information, including name, email, and contact details.
- Booking Management: View and manage your bookings, including checking in and checking out.

## Technologies Used

- Frontend: React, React Router, Axios, React Toastify
- Backend: Spring Boot, Spring Security, MongoDB, Spring Data MongoDB
- JWT (JSON Web Token) for user authentication

## Getting Started

### Prerequisites

- Node.js and npm for the frontend
- Java Development Kit (JDK) 11 or higher for the backend
- MongoDB database

### Installation

1. Clone the repository:
- git clone https://github.com/yourusername/wanderinn.git
- cd wanderinn 

2. Frontend Setup:

- cd wanderinn-frontend
- npm install


3. Backend Setup:

- Create a MongoDB database and update the MongoDB connection URI in `wanderinn-backend/src/main/resources/application.properties`.

- Run the backend Spring Boot application:

  ```
  cd wanderinn-backend
  ./mvnw spring-boot:run
  ```

4. Run the Frontend:

- cd wanderinn-frontend
- npm start


5. Open your browser and navigate to `http://localhost:3000` to access the WanderInn application.

## Usage

- Landing Page: Upon accessing the application, users will see the landing page with an overview of WanderInn.

- Register: New users can click on "Register" in the navbar to create an account by providing their email and password.

- Sign In: Returning users can click on "Sign In" in the navbar to log in with their registered email and password.

- Browse Hotels and Rooms: Once logged in, users can browse through the list of hotels and their available rooms.

- Search and Filter: Users can search for hotels based on location, price range, amenities, and more.

- Book a Room: Users can check room availability for specific dates and book rooms.

- User Profile: Users can view and update their profile information.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, feel free to open an issue or submit a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
