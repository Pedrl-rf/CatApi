
package com.example.catapi.models;


import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Datos implements Parcelable
{

    @SerializedName("adaptability")
    @Expose
    private int adaptability;
    @SerializedName("affection_level")
    @Expose
    private int affectionLevel;
    @SerializedName("alt_names")
    @Expose
    private String altNames;
    @SerializedName("cfa_url")
    @Expose
    private String cfaUrl;
    @SerializedName("child_friendly")
    @Expose
    private int childFriendly;
    @SerializedName("country_code")
    @Expose
    private String countryCode;
    @SerializedName("country_codes")
    @Expose
    private String countryCodes;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("dog_friendly")
    @Expose
    private int dogFriendly;
    @SerializedName("energy_level")
    @Expose
    private int energyLevel;
    @SerializedName("experimental")
    @Expose
    private int experimental;
    @SerializedName("grooming")
    @Expose
    private int grooming;
    @SerializedName("hairless")
    @Expose
    private int hairless;
    @SerializedName("health_issues")
    @Expose
    private int healthIssues;
    @SerializedName("hypoallergenic")
    @Expose
    private int hypoallergenic;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("image")
    @Expose
    private Image image;
    @SerializedName("indoor")
    @Expose
    private int indoor;
    @SerializedName("intelligence")
    @Expose
    private int intelligence;
    @SerializedName("lap")
    @Expose
    private int lap;
    @SerializedName("life_span")
    @Expose
    private String lifeSpan;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("natural")
    @Expose
    private int natural;
    @SerializedName("origin")
    @Expose
    private String origin;
    @SerializedName("rare")
    @Expose
    private int rare;
    @SerializedName("reference_image_id")
    @Expose
    private String referenceImageId;
    @SerializedName("rex")
    @Expose
    private int rex;
    @SerializedName("shedding_level")
    @Expose
    private int sheddingLevel;
    @SerializedName("short_legs")
    @Expose
    private int shortLegs;
    @SerializedName("social_needs")
    @Expose
    private int socialNeeds;
    @SerializedName("stranger_friendly")
    @Expose
    private int strangerFriendly;
    @SerializedName("suppressed_tail")
    @Expose
    private int suppressedTail;
    @SerializedName("temperament")
    @Expose
    private String temperament;
    @SerializedName("vcahospitals_url")
    @Expose
    private String vcahospitalsUrl;
    @SerializedName("vetstreet_url")
    @Expose
    private String vetstreetUrl;
    @SerializedName("vocalisation")
    @Expose
    private int vocalisation;
    @SerializedName("weight")
    @Expose
    private Weight weight;
    @SerializedName("wikipedia_url")
    @Expose
    private String wikipediaUrl;
    public final static Creator<Datos> CREATOR = new Creator<Datos>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Datos createFromParcel(android.os.Parcel in) {
            return new Datos(in);
        }

        public Datos[] newArray(int size) {
            return (new Datos[size]);
        }

    }
    ;

    protected Datos(android.os.Parcel in) {
        this.adaptability = ((int) in.readValue((int.class.getClassLoader())));
        this.affectionLevel = ((int) in.readValue((int.class.getClassLoader())));
        this.altNames = ((String) in.readValue((String.class.getClassLoader())));
        this.cfaUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.childFriendly = ((int) in.readValue((int.class.getClassLoader())));
        this.countryCode = ((String) in.readValue((String.class.getClassLoader())));
        this.countryCodes = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.dogFriendly = ((int) in.readValue((int.class.getClassLoader())));
        this.energyLevel = ((int) in.readValue((int.class.getClassLoader())));
        this.experimental = ((int) in.readValue((int.class.getClassLoader())));
        this.grooming = ((int) in.readValue((int.class.getClassLoader())));
        this.hairless = ((int) in.readValue((int.class.getClassLoader())));
        this.healthIssues = ((int) in.readValue((int.class.getClassLoader())));
        this.hypoallergenic = ((int) in.readValue((int.class.getClassLoader())));
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.image = ((Image) in.readValue((Image.class.getClassLoader())));
        this.indoor = ((int) in.readValue((int.class.getClassLoader())));
        this.intelligence = ((int) in.readValue((int.class.getClassLoader())));
        this.lap = ((int) in.readValue((int.class.getClassLoader())));
        this.lifeSpan = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.natural = ((int) in.readValue((int.class.getClassLoader())));
        this.origin = ((String) in.readValue((String.class.getClassLoader())));
        this.rare = ((int) in.readValue((int.class.getClassLoader())));
        this.referenceImageId = ((String) in.readValue((String.class.getClassLoader())));
        this.rex = ((int) in.readValue((int.class.getClassLoader())));
        this.sheddingLevel = ((int) in.readValue((int.class.getClassLoader())));
        this.shortLegs = ((int) in.readValue((int.class.getClassLoader())));
        this.socialNeeds = ((int) in.readValue((int.class.getClassLoader())));
        this.strangerFriendly = ((int) in.readValue((int.class.getClassLoader())));
        this.suppressedTail = ((int) in.readValue((int.class.getClassLoader())));
        this.temperament = ((String) in.readValue((String.class.getClassLoader())));
        this.vcahospitalsUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.vetstreetUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.vocalisation = ((int) in.readValue((int.class.getClassLoader())));
        this.weight = ((Weight) in.readValue((Weight.class.getClassLoader())));
        this.wikipediaUrl = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Datos() {
    }

    public int getAdaptability() {
        return adaptability;
    }

    public void setAdaptability(int adaptability) {
        this.adaptability = adaptability;
    }

    public int getAffectionLevel() {
        return affectionLevel;
    }

    public void setAffectionLevel(int affectionLevel) {
        this.affectionLevel = affectionLevel;
    }

    public String getAltNames() {
        return altNames;
    }

    public void setAltNames(String altNames) {
        this.altNames = altNames;
    }

    public String getCfaUrl() {
        return cfaUrl;
    }

    public void setCfaUrl(String cfaUrl) {
        this.cfaUrl = cfaUrl;
    }

    public int getChildFriendly() {
        return childFriendly;
    }

    public void setChildFriendly(int childFriendly) {
        this.childFriendly = childFriendly;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCodes() {
        return countryCodes;
    }

    public void setCountryCodes(String countryCodes) {
        this.countryCodes = countryCodes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDogFriendly() {
        return dogFriendly;
    }

    public void setDogFriendly(int dogFriendly) {
        this.dogFriendly = dogFriendly;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }

    public int getExperimental() {
        return experimental;
    }

    public void setExperimental(int experimental) {
        this.experimental = experimental;
    }

    public int getGrooming() {
        return grooming;
    }

    public void setGrooming(int grooming) {
        this.grooming = grooming;
    }

    public int getHairless() {
        return hairless;
    }

    public void setHairless(int hairless) {
        this.hairless = hairless;
    }

    public int getHealthIssues() {
        return healthIssues;
    }

    public void setHealthIssues(int healthIssues) {
        this.healthIssues = healthIssues;
    }

    public int getHypoallergenic() {
        return hypoallergenic;
    }

    public void setHypoallergenic(int hypoallergenic) {
        this.hypoallergenic = hypoallergenic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getIndoor() {
        return indoor;
    }

    public void setIndoor(int indoor) {
        this.indoor = indoor;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getLap() {
        return lap;
    }

    public void setLap(int lap) {
        this.lap = lap;
    }

    public String getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(String lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNatural() {
        return natural;
    }

    public void setNatural(int natural) {
        this.natural = natural;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getRare() {
        return rare;
    }

    public void setRare(int rare) {
        this.rare = rare;
    }

    public String getReferenceImageId() {
        return referenceImageId;
    }

    public void setReferenceImageId(String referenceImageId) {
        this.referenceImageId = referenceImageId;
    }

    public int getRex() {
        return rex;
    }

    public void setRex(int rex) {
        this.rex = rex;
    }

    public int getSheddingLevel() {
        return sheddingLevel;
    }

    public void setSheddingLevel(int sheddingLevel) {
        this.sheddingLevel = sheddingLevel;
    }

    public int getShortLegs() {
        return shortLegs;
    }

    public void setShortLegs(int shortLegs) {
        this.shortLegs = shortLegs;
    }

    public int getSocialNeeds() {
        return socialNeeds;
    }

    public void setSocialNeeds(int socialNeeds) {
        this.socialNeeds = socialNeeds;
    }

    public int getStrangerFriendly() {
        return strangerFriendly;
    }

    public void setStrangerFriendly(int strangerFriendly) {
        this.strangerFriendly = strangerFriendly;
    }

    public int getSuppressedTail() {
        return suppressedTail;
    }

    public void setSuppressedTail(int suppressedTail) {
        this.suppressedTail = suppressedTail;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public String getVcahospitalsUrl() {
        return vcahospitalsUrl;
    }

    public void setVcahospitalsUrl(String vcahospitalsUrl) {
        this.vcahospitalsUrl = vcahospitalsUrl;
    }

    public String getVetstreetUrl() {
        return vetstreetUrl;
    }

    public void setVetstreetUrl(String vetstreetUrl) {
        this.vetstreetUrl = vetstreetUrl;
    }

    public int getVocalisation() {
        return vocalisation;
    }

    public void setVocalisation(int vocalisation) {
        this.vocalisation = vocalisation;
    }

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    public String getWikipediaUrl() {
        return wikipediaUrl;
    }

    public void setWikipediaUrl(String wikipediaUrl) {
        this.wikipediaUrl = wikipediaUrl;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(adaptability);
        dest.writeValue(affectionLevel);
        dest.writeValue(altNames);
        dest.writeValue(cfaUrl);
        dest.writeValue(childFriendly);
        dest.writeValue(countryCode);
        dest.writeValue(countryCodes);
        dest.writeValue(description);
        dest.writeValue(dogFriendly);
        dest.writeValue(energyLevel);
        dest.writeValue(experimental);
        dest.writeValue(grooming);
        dest.writeValue(hairless);
        dest.writeValue(healthIssues);
        dest.writeValue(hypoallergenic);
        dest.writeValue(id);
        dest.writeValue(image);
        dest.writeValue(indoor);
        dest.writeValue(intelligence);
        dest.writeValue(lap);
        dest.writeValue(lifeSpan);
        dest.writeValue(name);
        dest.writeValue(natural);
        dest.writeValue(origin);
        dest.writeValue(rare);
        dest.writeValue(referenceImageId);
        dest.writeValue(rex);
        dest.writeValue(sheddingLevel);
        dest.writeValue(shortLegs);
        dest.writeValue(socialNeeds);
        dest.writeValue(strangerFriendly);
        dest.writeValue(suppressedTail);
        dest.writeValue(temperament);
        dest.writeValue(vcahospitalsUrl);
        dest.writeValue(vetstreetUrl);
        dest.writeValue(vocalisation);
        dest.writeValue(weight);
        dest.writeValue(wikipediaUrl);
    }

    public int describeContents() {
        return  0;
    }

}
