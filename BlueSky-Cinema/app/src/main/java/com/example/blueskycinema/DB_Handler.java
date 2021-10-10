  package com.example.blueskycinema;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.blueskycinema.Janani.FoodModelClass;

import java.util.ArrayList;

  public class DB_Handler extends SQLiteOpenHelper {

      Context context;

      //Database name
      public static final String DATABASE_NAME = "Movie.db";

      //No of seats in the theater
      public static final int NO_OF_SEATS = 200;
      public static final int NO_OF_BOX_SEATS = 15;

      //Movie table
      public static final String MOVIE_TABLE = "movies_table";
      public static final String MOVIE_COLUMN_ID = "movieID";
      public static final String MOVIE_COLUMN_NAME = "name";
      public static final String MOVIE_COLUMN_GENRE = "genre";
      public static final String MOVIE_COLUMN_DURATION = "duration";
      public static final String MOVIE_COLUMN_YEAR = "year";
      public static final String MOVIE_COLUMN_DESCRIPTION = "description";
      public static final String MOVIE_COLUMN_POSTER = "poster";
      public static final String MOVIE_COLUMN_COVER = "coverImage";
      public static final String MOVIE_COLUMN_TRAILER = "trailerLink";
      public static final String MOVIE_COLUMN_PRICE = "ticketPrice";

      //User table
      public static final String USER_TABLE = "users_table";
      public static final String USER_COLUMN_ID = "userID";
      public static final String USER_COLUMN_USERNAME = "username";
      public static final String USER_COLUMN_EMAIL = "email";
      public static final String USER_COLUMN_PASSWORD = "password";
      public static final String USER_COLUMN_CONTACT = "contact";
      public static final String USER_COLUMN_IMAGE = "image";

      //Admin table
      public static final String ADMIN_TABLE = "admin_table";
      public static final String ADMIN_COLUMN_ID = "adminID";
      public static final String ADMIN_COLUMN_NAME = "name";
      public static final String ADMIN_COLUMN_USERNAME = "username";
      public static final String ADMIN_COLUMN_PASSWORD = "password";

      //Booking table
      public static final String BOOKING_TABLE = "booking_table";
      public static final String BOOKING_COLUMN_N_TICKETS = "normalTickets";
      public static final String BOOKING_COLUMN_BOX_TICKETS = "boxTickets";
      public static final String BOOKING_COLUMN_DATE = "date";
      public static final String BOOKING_COLUMN_TIME = "time";
      public static final String BOOKING_COLUMN_AMOUNT = "amount";
      public static final String BOOKING_COLUMN_MOVIE_ID = "movieID";

      //Discount table
      public static final String DISCOUNT_TABLE = "discount_table";
      public static final String DISCOUNT_COLUMN_ID = "discountID";
      public static final String DISCOUNT_COLUMN_CODE = "couponCode";
      public static final String DISCOUNT_COLUMN_PERCENTAGE = "percentage";

      //Reviews table
      public static final String REVIEWS_TABLE = "reviews_table";
      public static final String REVIEWS_COLUMN_ID = "revID";
      public static final String REVIEWS_COLUMN_USERID = "userID";
      public static final String REVIEWS_COLUMN_MESSAGE = "message";
      public static final String REVIEWS_COLUMN_DATE = "date";

      //Rating table
      public static final String RATING_TABLE = "rating_table";
      public static final String RATING_COLUMN_ID = "ratingID";
      public static final String RATING_COLUMN_USERID = "userID";
      public static final String RATING_COLUMN_COUNT = "count";
      public static final String RATING_COLUMN_DATE = "date";

      //Favorite table
      public static final String FAVORITE_TABLE = "favorite_table";
      public static final String FAVORITE_COLUMN_ID = "favID";
      public static final String FAVORITE_COLUMN_USERID = "userID";
      public static final String FAVORITE_COLUMN_MOVIE_ID = "movieID";

      //Food table
      public static final String FOOD_TABLE = "food_table";
      public static final String FOOD_COLUMN_ID = "foodID";
      public static final String FOOD_COLUMN_NAME = "name";
      public static final String FOOD_COLUMN_IMAGE = "image";
      public static final String FOOD_COLUMN_PRICE = "price";

      //Order table
      public static final String ORDER_TABLE = "order_table";
      public static final String ORDER_COLUMN_ID = "orderID";
      public static final String ORDER_COLUMN_DATETIME = "date_time";
      public static final String ORDER_COLUMN_SHEET_NO = "sheetNumber";
      public static final String ORDER_COLUMN_TOTAL_ITEMS = "totalItems";
      public static final String ORDER_COLUMN_AMOUNT = "amount";
      public static final String ORDER_COLUMN_USERID = "userId";

      //Order_Food table
      public static final String ORDER_FOOD_TABLE = "order_food_table";
      public static final String ORDER_FOOD_COLUMN_ID = "orderID,foodID";
      public static final String ORDER_FOOD_COLUMN_PRODUCT_NAME = "productName";
      public static final String ORDER_FOOD_COLUMN_QUANTITY = "quantity";


      public DB_Handler(Context context) {
          super(context, DATABASE_NAME, null, 1);
      }

      @Override
      public void onCreate(SQLiteDatabase db) {

          //create movie table
          String create_movies_table =
                  "CREATE TABLE " + MOVIE_TABLE + " ( " +
                          MOVIE_COLUMN_ID + " INTEGER PRIMARY KEY, " +
                          MOVIE_COLUMN_NAME + " TEXT, " +
                          MOVIE_COLUMN_GENRE + " TEXT, " +
                          MOVIE_COLUMN_DURATION + " TEXT, " +
                          MOVIE_COLUMN_YEAR + " INTEGER, " +
                          MOVIE_COLUMN_DESCRIPTION + " TEXT, " +
                          MOVIE_COLUMN_POSTER + " BLOB, " +
                          MOVIE_COLUMN_COVER + " BLOB, " +
                          MOVIE_COLUMN_TRAILER + " TEXT, " +
                          MOVIE_COLUMN_PRICE + " REAL)";

          //create user table
          String create_users_table =
                  "CREATE TABLE " + USER_TABLE + " ( " +
                          USER_COLUMN_ID + " INTEGER PRIMARY KEY, " +
                          USER_COLUMN_USERNAME + " TEXT, " +
                          USER_COLUMN_EMAIL + " TEXT, " +
                          USER_COLUMN_PASSWORD + " TEXT, " +
                          USER_COLUMN_CONTACT + " TEXT, " +
                          USER_COLUMN_IMAGE + " BLOB)";

          //create admin table
          String create_admin_table =
                  "CREATE TABLE " + ADMIN_TABLE + " ( " +
                          ADMIN_COLUMN_ID + " INTEGER PRIMARY KEY, " +
                          ADMIN_COLUMN_NAME + " TEXT, " +
                          ADMIN_COLUMN_USERNAME + " TEXT, " +
                          ADMIN_COLUMN_PASSWORD + " TEXT)";

          //create booking table
          String create_booking_table =
                  "CREATE TABLE " + BOOKING_TABLE + " ( " +
                          BOOKING_COLUMN_N_TICKETS + " INTEGER PRIMARY KEY, " +
                          BOOKING_COLUMN_BOX_TICKETS + " INTEGER, " +
                          BOOKING_COLUMN_DATE + " DATE, " +
                          BOOKING_COLUMN_TIME + " DATETIME, " +
                          BOOKING_COLUMN_AMOUNT + " REAL, " +
                          BOOKING_COLUMN_MOVIE_ID + " INTEGER)";

          //create discount table
          String create_discount_table =
                  "CREATE TABLE " + DISCOUNT_TABLE + " ( " +
                          DISCOUNT_COLUMN_ID + " INTEGER PRIMARY KEY, " +
                          ADMIN_COLUMN_NAME + " TEXT, " +
                          DISCOUNT_COLUMN_CODE + " TEXT, " +
                          DISCOUNT_COLUMN_PERCENTAGE + " INTEGER)";

          //create review table
          String create_reviews_table =
                  "CREATE TABLE " + REVIEWS_TABLE + " ( " +
                          REVIEWS_COLUMN_ID + " INTEGER PRIMARY KEY, " +
                          REVIEWS_COLUMN_USERID + " INTEGER, " +
                          REVIEWS_COLUMN_MESSAGE + " TEXT, " +
                          REVIEWS_COLUMN_DATE + " DATE)";

          //create rating table
          String create_rating_table =
                  "CREATE TABLE " + RATING_TABLE + " ( " +
                          RATING_COLUMN_ID + " INTEGER PRIMARY KEY, " +
                          RATING_COLUMN_USERID + " INTEGER, " +
                          RATING_COLUMN_COUNT + " INTEGER, " +
                          RATING_COLUMN_DATE + " DATE)";

          //create favorite table
          String create_favorite_table =
                  "CREATE TABLE " + FAVORITE_TABLE + " ( " +
                          FAVORITE_COLUMN_ID + " INTEGER PRIMARY KEY, " +
                          FAVORITE_COLUMN_USERID + " INTEGER, " +
                          FAVORITE_COLUMN_MOVIE_ID + " INTEGER)";


          //create food table
          String create_food_table =
                  "CREATE TABLE " + FOOD_TABLE + " ( " +
                          FOOD_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                          FOOD_COLUMN_NAME + " TEXT, " +
                          FOOD_COLUMN_IMAGE + " BLOB, " +
                          FOOD_COLUMN_PRICE + " REAL)";

          //create order table
          String create_order_table =
                  "CREATE TABLE " + ORDER_TABLE + " ( " +
                          ORDER_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                          ORDER_COLUMN_DATETIME + " DATETIME, " +
                          ORDER_COLUMN_SHEET_NO + " TEXT, " +
                          ORDER_COLUMN_TOTAL_ITEMS + " INTEGER, " +
                          ORDER_COLUMN_AMOUNT + " REAL, " +
                          ORDER_COLUMN_USERID + " INTEGER)";

          //create order_food table
          String create_order_food_table =
                  "CREATE TABLE " + ORDER_FOOD_TABLE + " ( " +
                          ORDER_FOOD_COLUMN_ID + " PRIMARY KEY, " +
                          ORDER_FOOD_COLUMN_PRODUCT_NAME + " TEXT, " +
                          ORDER_FOOD_COLUMN_QUANTITY + " REAL)";


          //execute tables

          try {
              db.execSQL(create_movies_table);
              db.execSQL(create_users_table);
              db.execSQL(create_admin_table);

              db.execSQL(create_booking_table);
              db.execSQL(create_discount_table);

              db.execSQL(create_reviews_table);
              db.execSQL(create_rating_table);
              db.execSQL(create_favorite_table);

              db.execSQL(create_food_table);
              db.execSQL(create_order_table);
              db.execSQL(create_order_food_table);

              //Toast.makeText(context, "Table created successfully!", Toast.LENGTH_SHORT).show();
          } catch (Exception e) {
              //Toast.makeText(context, "Table creation failed!:", Toast.LENGTH_SHORT).show();
          }

      }

      @Override
      public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

      }

      //Zaid function implementation123


      //Imasha function implementation


      //Hasith function implementation


      //Janani function implementation

      //Theatre Add Food

      public long addFood(String foodName, String price) {
          //gets the data repository in write mode
          SQLiteDatabase myDB = getWritableDatabase();

          //create a new map of values, where column names the keys
          ContentValues values = new ContentValues();
          values.put(FOOD_COLUMN_NAME, foodName);
          values.put(FOOD_COLUMN_PRICE, price);

          //Insert the new raw, returning primary key value of the new raw
          long newFood = myDB.insert(FOOD_TABLE, null, values);
          return newFood;
      }

      //Theatre Retrieve Food Data
      public ArrayList<FoodModelClass> getAllFoodData(String orderBy) {
          ArrayList<FoodModelClass> arrayList = new ArrayList<>();

          //Select all info in database
          String selectQuery = "SELECT * FROM " + FOOD_TABLE + " ORDER BY " + orderBy;
          SQLiteDatabase db = this.getWritableDatabase();
          Cursor cursor = db.rawQuery(selectQuery, null);

          //Get the data from columns
          if (cursor.moveToNext()) {
              do {
                  FoodModelClass model = new FoodModelClass(
                          "" + cursor.getInt(cursor.getColumnIndex(FOOD_COLUMN_ID)),
                          "" + cursor.getString(cursor.getColumnIndex(FOOD_COLUMN_NAME)),
                          "" + cursor.getString(cursor.getColumnIndex(FOOD_COLUMN_PRICE))
                  );
                  arrayList.add(model);
              } while (cursor.moveToNext());
          }
          db.close();
          return arrayList;
      }
      // Count data table records
      public int countFoodList() {

          SQLiteDatabase db = getReadableDatabase();
          String query = "SELECT * FROM " + FOOD_TABLE;

          Cursor cursor = db.rawQuery(query, null);
          return cursor.getCount();
      }

      //Update Data

      public int updateInfo(FoodModelClass model){

          //gets the data repository in write mode
          SQLiteDatabase myDB = getWritableDatabase();

          //create a new map of values, where column names the keys
          ContentValues values = new ContentValues();
          values.put(FOOD_COLUMN_NAME, model.getFoodName());
          values.put(FOOD_COLUMN_PRICE, model.getFoodPrice());

          //Update the new raw, returning primary key value of the new raw
          int status = myDB.update(FOOD_TABLE, values, FOOD_COLUMN_ID +" =? ", new String[]{String.valueOf(model.getFoodID())});
          myDB.close();
          return status;

      }


      //get a single food info

      public FoodModelClass getSingleFood(int id){

          SQLiteDatabase db = getReadableDatabase();
          Cursor cursor = db.query(FOOD_TABLE, new String[]{
                  FOOD_COLUMN_ID,
                  FOOD_COLUMN_NAME,
                  FOOD_COLUMN_IMAGE,
                  FOOD_COLUMN_PRICE,

          },FOOD_COLUMN_ID + " = ?", new String[]{String.valueOf(id)}, null, null, null);
          FoodModelClass FModel;
          if (cursor != null){
              cursor.moveToFirst();
              FModel = new FoodModelClass(
                      cursor.getString(0),
                      cursor.getString(1),
                      cursor.getString(2)
              );
              return FModel;
          }
          return null;
      }

      //Delete a food

      public void deleteInfo (String id) {
          SQLiteDatabase db = getWritableDatabase();
          db.delete(FOOD_TABLE, FOOD_COLUMN_ID + " = ? ", new String[]{id});
          db.close();
      }















  }





