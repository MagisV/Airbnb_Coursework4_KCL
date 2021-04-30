 

import java.net.URL;
import java.util.ArrayList;

/**
 * Represents one listing of a property for rental on Airbnb.
 * This is essentially one row in the data table. Each column
 * has a corresponding field.
 */ 

public class AirbnbListing implements Comparable{

    /**
     * The id and name of the individual property
     */
    private final String id;
    private final String name;

    /**
     * Overview of neighbourhood
     */
    private final String neighbourhoodOverview;

    /**
     * Url of picture showing the property
     */
    private final URL pictureUrl;

    /**
     * The id and name of the host for this listing.
     * Each listing has only one host, but one host may
     * list many properties.
     */
    private final String hostID;
    private final String hostName;

    /**
     * The time a host usually takes to respond. (Descriptions like "within a few hours")
     * Can be N/A
     */
    private final String hostResponseTime;

    /**
     * Whether the host has reached the status of superhost.
     */
    private final boolean hostIsSuperhost;

    private final URL hostThumbnail;
    private final URL hostPicture;


    /**
     * The total number of boroughListings the host holds across AirBnB
     */
    private final int hostListingsCount;

    /**
     * The grouped location to where the listed property is situated.
     * For this data set, it is a london borough.
     */
    private String neighbourhood;

    /**
     * The location on a map where the property is situated.
     */
    private final double latitude;
    private final double longitude;

    /**
     * The type of property, either "Private room" or "Entire Home/apt".
     */
    private final String roomType;

    /**
     * The maximum number of guests this property can accommodate.
     */
    private final int maxGuests;

    /**
     * A Description of the available bathrooms.
     * Strings have some differences in spelling and can be null.
     */
    private final String bathroomsText;

    /**
     * The amount of available beds.
     */
    private final int bedrooms;

    /**
     * A list of the amenities the host provides
     */
    private final ArrayList<String> amenities;

    /**
     * The price per night's stay
     */
    private final int price;

    /**
     * The minimum and maximum number of nights the listed property must and can be booked for.
     */
    private final int minimumNights;
    private final int maximumNights;

    /**
     * The total number of days in the year that the property is available for
     */
    private final int availability365;

    /**
     * Stats related to the rating of a property
     */
    private final int numberOfReviews;
    private final int reviewScoresRating;
    private final int reviewScoresCleanliness;
    private final int reviewScoresCommunication;
    private final int reviewScoresLocation;
    private final double reviewsPerMonth;


    public AirbnbListing(String id, String name, String neighbourhoodOverview, URL pictureUrl, String hostID,
                         String hostName, String hostResponseTime, boolean hostIsSuperhost, URL hostThumbnail, URL hostPicture,
                         int hostListingsCount, String neighbourhood, double latitude, double longitude, String roomType,
                         int maxGuests, String bathroomsText, int bedrooms, ArrayList<String> amenities, int price,
                         int minimumNights, int maximumNights, int availability365, int numberOfReviews,
                         int reviewScoresRating, int reviewScoresCleanliness, int reviewScoresCommunication,
                         int reviewScoresLocation, double reviewsPerMonth) {
        this.id = id;
        this.name = name;
        this.neighbourhoodOverview = neighbourhoodOverview;
        this.pictureUrl = pictureUrl;
        this.hostID = hostID;
        this.hostName = hostName;
        this.hostResponseTime = hostResponseTime;
        this.hostIsSuperhost = hostIsSuperhost;
        this.hostThumbnail = hostThumbnail;
        this.hostPicture = hostPicture;
        this.hostListingsCount = hostListingsCount;
        this.neighbourhood = neighbourhood;
        this.latitude = latitude;
        this.longitude = longitude;
        this.roomType = roomType;
        this.maxGuests = maxGuests;
        this.bathroomsText = bathroomsText;
        this.bedrooms = bedrooms;
        this.amenities = amenities;
        this.price = price;
        this.minimumNights = minimumNights;
        this.maximumNights = maximumNights;
        this.availability365 = availability365;
        this.numberOfReviews = numberOfReviews;
        this.reviewScoresRating = reviewScoresRating;
        this.reviewScoresCleanliness = reviewScoresCleanliness;
        this.reviewScoresCommunication = reviewScoresCommunication;
        this.reviewScoresLocation = reviewScoresLocation;
        this.reviewsPerMonth = reviewsPerMonth;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNeighbourhoodOverview() {
        return neighbourhoodOverview;
    }

    public URL getPictureUrl() {
        return pictureUrl;
    }

    public String getHostName() {
        return hostName;
    }

    public boolean isHostSuperhost() {
        return hostIsSuperhost;
    }

    public URL getHostPicture() {
        return hostPicture;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void chopNeighbourhoodName() {
        String[] tempString = neighbourhood.split(" ", 2);
        neighbourhood = tempString[0];
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getMaxGuests() {
        return maxGuests;
    }

    public String getBathroomsText() {
        return bathroomsText;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public ArrayList<String> getAmenities() {
        return amenities;
    }

    public int getPrice() {
        return price;
    }

    public int getMinimumNights() {
        return minimumNights;
    }

    public int getMaximumNights() {
        return maximumNights;
    }

    public int getAvailability365() {
        return availability365;
    }

    public int getNumberOfReviews() {
        return numberOfReviews;
    }

    public int getReviewScoresRating() {
        return reviewScoresRating;
    }

    public int getReviewScoresCleanliness() {
        return reviewScoresCleanliness;
    }

    public int getReviewScoresCommunication() {
        return reviewScoresCommunication;
    }

    public int getReviewScoresLocation() {
        return reviewScoresLocation;
    }

    /**
     * The average price of a listing is calculated by the price per night * the minimum nights
     * @return The average price
     */
    public int getAveragePrice() { return price * minimumNights; }

    /**
     * Compare to listings
     * @param o The listing to compare this listing to.
     * @return 0 if the listings are the same, 1 if the id of this listing is larger than the compared one and -1 if the compared one is larger.
     */
    @Override
    public int compareTo(Object o) {
        if (o.getClass() == AirbnbListing.class)
        {
            AirbnbListing otherListing = (AirbnbListing) o;
            int thisId = Integer.parseInt(this.getId());
            int otherId = Integer.parseInt(otherListing.getId());
            if (this.getId().equals(otherListing.getId()))
                return 0;
            else if (thisId < otherId)
                return -1;
            else if (thisId > otherId)
                return 1;
        }
        return 0;
    }
}


