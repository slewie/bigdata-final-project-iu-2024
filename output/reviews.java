// ORM class for table 'reviews'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Sun May 12 14:48:22 MSK 2024
// For connector: org.apache.sqoop.manager.PostgresqlManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import org.apache.sqoop.lib.JdbcWritableBridge;
import org.apache.sqoop.lib.DelimiterSet;
import org.apache.sqoop.lib.FieldFormatter;
import org.apache.sqoop.lib.RecordParser;
import org.apache.sqoop.lib.BooleanParser;
import org.apache.sqoop.lib.BlobRef;
import org.apache.sqoop.lib.ClobRef;
import org.apache.sqoop.lib.LargeObjectLoader;
import org.apache.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class reviews extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  public static interface FieldSetterCommand {    void setField(Object value);  }  protected ResultSet __cur_result_set;
  private Map<String, FieldSetterCommand> setters = new HashMap<String, FieldSetterCommand>();
  private void init0() {
    setters.put("id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        reviews.this.id = (Integer)value;
      }
    });
    setters.put("app_id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        reviews.this.app_id = (Integer)value;
      }
    });
    setters.put("appname", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        reviews.this.appname = (String)value;
      }
    });
    setters.put("review_id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        reviews.this.review_id = (Integer)value;
      }
    });
    setters.put("language", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        reviews.this.language = (String)value;
      }
    });
    setters.put("review", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        reviews.this.review = (String)value;
      }
    });
    setters.put("time_date_created", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        reviews.this.time_date_created = (java.sql.Timestamp)value;
      }
    });
    setters.put("time_date_updated", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        reviews.this.time_date_updated = (java.sql.Timestamp)value;
      }
    });
    setters.put("recommended", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        reviews.this.recommended = (Boolean)value;
      }
    });
    setters.put("votes_helpful", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        reviews.this.votes_helpful = (Long)value;
      }
    });
    setters.put("votes_funny", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        reviews.this.votes_funny = (Long)value;
      }
    });
    setters.put("weighted_vote_score", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        reviews.this.weighted_vote_score = (Double)value;
      }
    });
    setters.put("comment_count", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        reviews.this.comment_count = (Long)value;
      }
    });
    setters.put("steam_purchase", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        reviews.this.steam_purchase = (Boolean)value;
      }
    });
    setters.put("received_for_free", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        reviews.this.received_for_free = (Boolean)value;
      }
    });
    setters.put("written_during_early_access", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        reviews.this.written_during_early_access = (Boolean)value;
      }
    });
    setters.put("author_steamid", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        reviews.this.author_steamid = (Long)value;
      }
    });
    setters.put("playtime_forever", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        reviews.this.playtime_forever = (Double)value;
      }
    });
    setters.put("playtime_last_two_weeks", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        reviews.this.playtime_last_two_weeks = (Double)value;
      }
    });
    setters.put("playtime_at_review", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        reviews.this.playtime_at_review = (Double)value;
      }
    });
    setters.put("last_played", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        reviews.this.last_played = (java.sql.Timestamp)value;
      }
    });
  }
  public reviews() {
    init0();
  }
  private Integer id;
  public Integer get_id() {
    return id;
  }
  public void set_id(Integer id) {
    this.id = id;
  }
  public reviews with_id(Integer id) {
    this.id = id;
    return this;
  }
  private Integer app_id;
  public Integer get_app_id() {
    return app_id;
  }
  public void set_app_id(Integer app_id) {
    this.app_id = app_id;
  }
  public reviews with_app_id(Integer app_id) {
    this.app_id = app_id;
    return this;
  }
  private String appname;
  public String get_appname() {
    return appname;
  }
  public void set_appname(String appname) {
    this.appname = appname;
  }
  public reviews with_appname(String appname) {
    this.appname = appname;
    return this;
  }
  private Integer review_id;
  public Integer get_review_id() {
    return review_id;
  }
  public void set_review_id(Integer review_id) {
    this.review_id = review_id;
  }
  public reviews with_review_id(Integer review_id) {
    this.review_id = review_id;
    return this;
  }
  private String language;
  public String get_language() {
    return language;
  }
  public void set_language(String language) {
    this.language = language;
  }
  public reviews with_language(String language) {
    this.language = language;
    return this;
  }
  private String review;
  public String get_review() {
    return review;
  }
  public void set_review(String review) {
    this.review = review;
  }
  public reviews with_review(String review) {
    this.review = review;
    return this;
  }
  private java.sql.Timestamp time_date_created;
  public java.sql.Timestamp get_time_date_created() {
    return time_date_created;
  }
  public void set_time_date_created(java.sql.Timestamp time_date_created) {
    this.time_date_created = time_date_created;
  }
  public reviews with_time_date_created(java.sql.Timestamp time_date_created) {
    this.time_date_created = time_date_created;
    return this;
  }
  private java.sql.Timestamp time_date_updated;
  public java.sql.Timestamp get_time_date_updated() {
    return time_date_updated;
  }
  public void set_time_date_updated(java.sql.Timestamp time_date_updated) {
    this.time_date_updated = time_date_updated;
  }
  public reviews with_time_date_updated(java.sql.Timestamp time_date_updated) {
    this.time_date_updated = time_date_updated;
    return this;
  }
  private Boolean recommended;
  public Boolean get_recommended() {
    return recommended;
  }
  public void set_recommended(Boolean recommended) {
    this.recommended = recommended;
  }
  public reviews with_recommended(Boolean recommended) {
    this.recommended = recommended;
    return this;
  }
  private Long votes_helpful;
  public Long get_votes_helpful() {
    return votes_helpful;
  }
  public void set_votes_helpful(Long votes_helpful) {
    this.votes_helpful = votes_helpful;
  }
  public reviews with_votes_helpful(Long votes_helpful) {
    this.votes_helpful = votes_helpful;
    return this;
  }
  private Long votes_funny;
  public Long get_votes_funny() {
    return votes_funny;
  }
  public void set_votes_funny(Long votes_funny) {
    this.votes_funny = votes_funny;
  }
  public reviews with_votes_funny(Long votes_funny) {
    this.votes_funny = votes_funny;
    return this;
  }
  private Double weighted_vote_score;
  public Double get_weighted_vote_score() {
    return weighted_vote_score;
  }
  public void set_weighted_vote_score(Double weighted_vote_score) {
    this.weighted_vote_score = weighted_vote_score;
  }
  public reviews with_weighted_vote_score(Double weighted_vote_score) {
    this.weighted_vote_score = weighted_vote_score;
    return this;
  }
  private Long comment_count;
  public Long get_comment_count() {
    return comment_count;
  }
  public void set_comment_count(Long comment_count) {
    this.comment_count = comment_count;
  }
  public reviews with_comment_count(Long comment_count) {
    this.comment_count = comment_count;
    return this;
  }
  private Boolean steam_purchase;
  public Boolean get_steam_purchase() {
    return steam_purchase;
  }
  public void set_steam_purchase(Boolean steam_purchase) {
    this.steam_purchase = steam_purchase;
  }
  public reviews with_steam_purchase(Boolean steam_purchase) {
    this.steam_purchase = steam_purchase;
    return this;
  }
  private Boolean received_for_free;
  public Boolean get_received_for_free() {
    return received_for_free;
  }
  public void set_received_for_free(Boolean received_for_free) {
    this.received_for_free = received_for_free;
  }
  public reviews with_received_for_free(Boolean received_for_free) {
    this.received_for_free = received_for_free;
    return this;
  }
  private Boolean written_during_early_access;
  public Boolean get_written_during_early_access() {
    return written_during_early_access;
  }
  public void set_written_during_early_access(Boolean written_during_early_access) {
    this.written_during_early_access = written_during_early_access;
  }
  public reviews with_written_during_early_access(Boolean written_during_early_access) {
    this.written_during_early_access = written_during_early_access;
    return this;
  }
  private Long author_steamid;
  public Long get_author_steamid() {
    return author_steamid;
  }
  public void set_author_steamid(Long author_steamid) {
    this.author_steamid = author_steamid;
  }
  public reviews with_author_steamid(Long author_steamid) {
    this.author_steamid = author_steamid;
    return this;
  }
  private Double playtime_forever;
  public Double get_playtime_forever() {
    return playtime_forever;
  }
  public void set_playtime_forever(Double playtime_forever) {
    this.playtime_forever = playtime_forever;
  }
  public reviews with_playtime_forever(Double playtime_forever) {
    this.playtime_forever = playtime_forever;
    return this;
  }
  private Double playtime_last_two_weeks;
  public Double get_playtime_last_two_weeks() {
    return playtime_last_two_weeks;
  }
  public void set_playtime_last_two_weeks(Double playtime_last_two_weeks) {
    this.playtime_last_two_weeks = playtime_last_two_weeks;
  }
  public reviews with_playtime_last_two_weeks(Double playtime_last_two_weeks) {
    this.playtime_last_two_weeks = playtime_last_two_weeks;
    return this;
  }
  private Double playtime_at_review;
  public Double get_playtime_at_review() {
    return playtime_at_review;
  }
  public void set_playtime_at_review(Double playtime_at_review) {
    this.playtime_at_review = playtime_at_review;
  }
  public reviews with_playtime_at_review(Double playtime_at_review) {
    this.playtime_at_review = playtime_at_review;
    return this;
  }
  private java.sql.Timestamp last_played;
  public java.sql.Timestamp get_last_played() {
    return last_played;
  }
  public void set_last_played(java.sql.Timestamp last_played) {
    this.last_played = last_played;
  }
  public reviews with_last_played(java.sql.Timestamp last_played) {
    this.last_played = last_played;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof reviews)) {
      return false;
    }
    reviews that = (reviews) o;
    boolean equal = true;
    equal = equal && (this.id == null ? that.id == null : this.id.equals(that.id));
    equal = equal && (this.app_id == null ? that.app_id == null : this.app_id.equals(that.app_id));
    equal = equal && (this.appname == null ? that.appname == null : this.appname.equals(that.appname));
    equal = equal && (this.review_id == null ? that.review_id == null : this.review_id.equals(that.review_id));
    equal = equal && (this.language == null ? that.language == null : this.language.equals(that.language));
    equal = equal && (this.review == null ? that.review == null : this.review.equals(that.review));
    equal = equal && (this.time_date_created == null ? that.time_date_created == null : this.time_date_created.equals(that.time_date_created));
    equal = equal && (this.time_date_updated == null ? that.time_date_updated == null : this.time_date_updated.equals(that.time_date_updated));
    equal = equal && (this.recommended == null ? that.recommended == null : this.recommended.equals(that.recommended));
    equal = equal && (this.votes_helpful == null ? that.votes_helpful == null : this.votes_helpful.equals(that.votes_helpful));
    equal = equal && (this.votes_funny == null ? that.votes_funny == null : this.votes_funny.equals(that.votes_funny));
    equal = equal && (this.weighted_vote_score == null ? that.weighted_vote_score == null : this.weighted_vote_score.equals(that.weighted_vote_score));
    equal = equal && (this.comment_count == null ? that.comment_count == null : this.comment_count.equals(that.comment_count));
    equal = equal && (this.steam_purchase == null ? that.steam_purchase == null : this.steam_purchase.equals(that.steam_purchase));
    equal = equal && (this.received_for_free == null ? that.received_for_free == null : this.received_for_free.equals(that.received_for_free));
    equal = equal && (this.written_during_early_access == null ? that.written_during_early_access == null : this.written_during_early_access.equals(that.written_during_early_access));
    equal = equal && (this.author_steamid == null ? that.author_steamid == null : this.author_steamid.equals(that.author_steamid));
    equal = equal && (this.playtime_forever == null ? that.playtime_forever == null : this.playtime_forever.equals(that.playtime_forever));
    equal = equal && (this.playtime_last_two_weeks == null ? that.playtime_last_two_weeks == null : this.playtime_last_two_weeks.equals(that.playtime_last_two_weeks));
    equal = equal && (this.playtime_at_review == null ? that.playtime_at_review == null : this.playtime_at_review.equals(that.playtime_at_review));
    equal = equal && (this.last_played == null ? that.last_played == null : this.last_played.equals(that.last_played));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof reviews)) {
      return false;
    }
    reviews that = (reviews) o;
    boolean equal = true;
    equal = equal && (this.id == null ? that.id == null : this.id.equals(that.id));
    equal = equal && (this.app_id == null ? that.app_id == null : this.app_id.equals(that.app_id));
    equal = equal && (this.appname == null ? that.appname == null : this.appname.equals(that.appname));
    equal = equal && (this.review_id == null ? that.review_id == null : this.review_id.equals(that.review_id));
    equal = equal && (this.language == null ? that.language == null : this.language.equals(that.language));
    equal = equal && (this.review == null ? that.review == null : this.review.equals(that.review));
    equal = equal && (this.time_date_created == null ? that.time_date_created == null : this.time_date_created.equals(that.time_date_created));
    equal = equal && (this.time_date_updated == null ? that.time_date_updated == null : this.time_date_updated.equals(that.time_date_updated));
    equal = equal && (this.recommended == null ? that.recommended == null : this.recommended.equals(that.recommended));
    equal = equal && (this.votes_helpful == null ? that.votes_helpful == null : this.votes_helpful.equals(that.votes_helpful));
    equal = equal && (this.votes_funny == null ? that.votes_funny == null : this.votes_funny.equals(that.votes_funny));
    equal = equal && (this.weighted_vote_score == null ? that.weighted_vote_score == null : this.weighted_vote_score.equals(that.weighted_vote_score));
    equal = equal && (this.comment_count == null ? that.comment_count == null : this.comment_count.equals(that.comment_count));
    equal = equal && (this.steam_purchase == null ? that.steam_purchase == null : this.steam_purchase.equals(that.steam_purchase));
    equal = equal && (this.received_for_free == null ? that.received_for_free == null : this.received_for_free.equals(that.received_for_free));
    equal = equal && (this.written_during_early_access == null ? that.written_during_early_access == null : this.written_during_early_access.equals(that.written_during_early_access));
    equal = equal && (this.author_steamid == null ? that.author_steamid == null : this.author_steamid.equals(that.author_steamid));
    equal = equal && (this.playtime_forever == null ? that.playtime_forever == null : this.playtime_forever.equals(that.playtime_forever));
    equal = equal && (this.playtime_last_two_weeks == null ? that.playtime_last_two_weeks == null : this.playtime_last_two_weeks.equals(that.playtime_last_two_weeks));
    equal = equal && (this.playtime_at_review == null ? that.playtime_at_review == null : this.playtime_at_review.equals(that.playtime_at_review));
    equal = equal && (this.last_played == null ? that.last_played == null : this.last_played.equals(that.last_played));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.app_id = JdbcWritableBridge.readInteger(2, __dbResults);
    this.appname = JdbcWritableBridge.readString(3, __dbResults);
    this.review_id = JdbcWritableBridge.readInteger(4, __dbResults);
    this.language = JdbcWritableBridge.readString(5, __dbResults);
    this.review = JdbcWritableBridge.readString(6, __dbResults);
    this.time_date_created = JdbcWritableBridge.readTimestamp(7, __dbResults);
    this.time_date_updated = JdbcWritableBridge.readTimestamp(8, __dbResults);
    this.recommended = JdbcWritableBridge.readBoolean(9, __dbResults);
    this.votes_helpful = JdbcWritableBridge.readLong(10, __dbResults);
    this.votes_funny = JdbcWritableBridge.readLong(11, __dbResults);
    this.weighted_vote_score = JdbcWritableBridge.readDouble(12, __dbResults);
    this.comment_count = JdbcWritableBridge.readLong(13, __dbResults);
    this.steam_purchase = JdbcWritableBridge.readBoolean(14, __dbResults);
    this.received_for_free = JdbcWritableBridge.readBoolean(15, __dbResults);
    this.written_during_early_access = JdbcWritableBridge.readBoolean(16, __dbResults);
    this.author_steamid = JdbcWritableBridge.readLong(17, __dbResults);
    this.playtime_forever = JdbcWritableBridge.readDouble(18, __dbResults);
    this.playtime_last_two_weeks = JdbcWritableBridge.readDouble(19, __dbResults);
    this.playtime_at_review = JdbcWritableBridge.readDouble(20, __dbResults);
    this.last_played = JdbcWritableBridge.readTimestamp(21, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.app_id = JdbcWritableBridge.readInteger(2, __dbResults);
    this.appname = JdbcWritableBridge.readString(3, __dbResults);
    this.review_id = JdbcWritableBridge.readInteger(4, __dbResults);
    this.language = JdbcWritableBridge.readString(5, __dbResults);
    this.review = JdbcWritableBridge.readString(6, __dbResults);
    this.time_date_created = JdbcWritableBridge.readTimestamp(7, __dbResults);
    this.time_date_updated = JdbcWritableBridge.readTimestamp(8, __dbResults);
    this.recommended = JdbcWritableBridge.readBoolean(9, __dbResults);
    this.votes_helpful = JdbcWritableBridge.readLong(10, __dbResults);
    this.votes_funny = JdbcWritableBridge.readLong(11, __dbResults);
    this.weighted_vote_score = JdbcWritableBridge.readDouble(12, __dbResults);
    this.comment_count = JdbcWritableBridge.readLong(13, __dbResults);
    this.steam_purchase = JdbcWritableBridge.readBoolean(14, __dbResults);
    this.received_for_free = JdbcWritableBridge.readBoolean(15, __dbResults);
    this.written_during_early_access = JdbcWritableBridge.readBoolean(16, __dbResults);
    this.author_steamid = JdbcWritableBridge.readLong(17, __dbResults);
    this.playtime_forever = JdbcWritableBridge.readDouble(18, __dbResults);
    this.playtime_last_two_weeks = JdbcWritableBridge.readDouble(19, __dbResults);
    this.playtime_at_review = JdbcWritableBridge.readDouble(20, __dbResults);
    this.last_played = JdbcWritableBridge.readTimestamp(21, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(id, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(app_id, 2 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(appname, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(review_id, 4 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(language, 5 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(review, 6 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeTimestamp(time_date_created, 7 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeTimestamp(time_date_updated, 8 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeBoolean(recommended, 9 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeLong(votes_helpful, 10 + __off, -5, __dbStmt);
    JdbcWritableBridge.writeLong(votes_funny, 11 + __off, -5, __dbStmt);
    JdbcWritableBridge.writeDouble(weighted_vote_score, 12 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeLong(comment_count, 13 + __off, -5, __dbStmt);
    JdbcWritableBridge.writeBoolean(steam_purchase, 14 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeBoolean(received_for_free, 15 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeBoolean(written_during_early_access, 16 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeLong(author_steamid, 17 + __off, -5, __dbStmt);
    JdbcWritableBridge.writeDouble(playtime_forever, 18 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(playtime_last_two_weeks, 19 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(playtime_at_review, 20 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeTimestamp(last_played, 21 + __off, 93, __dbStmt);
    return 21;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(id, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(app_id, 2 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(appname, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(review_id, 4 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(language, 5 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(review, 6 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeTimestamp(time_date_created, 7 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeTimestamp(time_date_updated, 8 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeBoolean(recommended, 9 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeLong(votes_helpful, 10 + __off, -5, __dbStmt);
    JdbcWritableBridge.writeLong(votes_funny, 11 + __off, -5, __dbStmt);
    JdbcWritableBridge.writeDouble(weighted_vote_score, 12 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeLong(comment_count, 13 + __off, -5, __dbStmt);
    JdbcWritableBridge.writeBoolean(steam_purchase, 14 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeBoolean(received_for_free, 15 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeBoolean(written_during_early_access, 16 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeLong(author_steamid, 17 + __off, -5, __dbStmt);
    JdbcWritableBridge.writeDouble(playtime_forever, 18 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(playtime_last_two_weeks, 19 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(playtime_at_review, 20 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeTimestamp(last_played, 21 + __off, 93, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.id = null;
    } else {
    this.id = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.app_id = null;
    } else {
    this.app_id = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.appname = null;
    } else {
    this.appname = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.review_id = null;
    } else {
    this.review_id = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.language = null;
    } else {
    this.language = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.review = null;
    } else {
    this.review = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.time_date_created = null;
    } else {
    this.time_date_created = new Timestamp(__dataIn.readLong());
    this.time_date_created.setNanos(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.time_date_updated = null;
    } else {
    this.time_date_updated = new Timestamp(__dataIn.readLong());
    this.time_date_updated.setNanos(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.recommended = null;
    } else {
    this.recommended = Boolean.valueOf(__dataIn.readBoolean());
    }
    if (__dataIn.readBoolean()) { 
        this.votes_helpful = null;
    } else {
    this.votes_helpful = Long.valueOf(__dataIn.readLong());
    }
    if (__dataIn.readBoolean()) { 
        this.votes_funny = null;
    } else {
    this.votes_funny = Long.valueOf(__dataIn.readLong());
    }
    if (__dataIn.readBoolean()) { 
        this.weighted_vote_score = null;
    } else {
    this.weighted_vote_score = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.comment_count = null;
    } else {
    this.comment_count = Long.valueOf(__dataIn.readLong());
    }
    if (__dataIn.readBoolean()) { 
        this.steam_purchase = null;
    } else {
    this.steam_purchase = Boolean.valueOf(__dataIn.readBoolean());
    }
    if (__dataIn.readBoolean()) { 
        this.received_for_free = null;
    } else {
    this.received_for_free = Boolean.valueOf(__dataIn.readBoolean());
    }
    if (__dataIn.readBoolean()) { 
        this.written_during_early_access = null;
    } else {
    this.written_during_early_access = Boolean.valueOf(__dataIn.readBoolean());
    }
    if (__dataIn.readBoolean()) { 
        this.author_steamid = null;
    } else {
    this.author_steamid = Long.valueOf(__dataIn.readLong());
    }
    if (__dataIn.readBoolean()) { 
        this.playtime_forever = null;
    } else {
    this.playtime_forever = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.playtime_last_two_weeks = null;
    } else {
    this.playtime_last_two_weeks = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.playtime_at_review = null;
    } else {
    this.playtime_at_review = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.last_played = null;
    } else {
    this.last_played = new Timestamp(__dataIn.readLong());
    this.last_played.setNanos(__dataIn.readInt());
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.id);
    }
    if (null == this.app_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.app_id);
    }
    if (null == this.appname) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, appname);
    }
    if (null == this.review_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.review_id);
    }
    if (null == this.language) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, language);
    }
    if (null == this.review) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, review);
    }
    if (null == this.time_date_created) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.time_date_created.getTime());
    __dataOut.writeInt(this.time_date_created.getNanos());
    }
    if (null == this.time_date_updated) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.time_date_updated.getTime());
    __dataOut.writeInt(this.time_date_updated.getNanos());
    }
    if (null == this.recommended) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.recommended);
    }
    if (null == this.votes_helpful) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.votes_helpful);
    }
    if (null == this.votes_funny) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.votes_funny);
    }
    if (null == this.weighted_vote_score) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.weighted_vote_score);
    }
    if (null == this.comment_count) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.comment_count);
    }
    if (null == this.steam_purchase) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.steam_purchase);
    }
    if (null == this.received_for_free) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.received_for_free);
    }
    if (null == this.written_during_early_access) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.written_during_early_access);
    }
    if (null == this.author_steamid) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.author_steamid);
    }
    if (null == this.playtime_forever) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.playtime_forever);
    }
    if (null == this.playtime_last_two_weeks) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.playtime_last_two_weeks);
    }
    if (null == this.playtime_at_review) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.playtime_at_review);
    }
    if (null == this.last_played) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.last_played.getTime());
    __dataOut.writeInt(this.last_played.getNanos());
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.id);
    }
    if (null == this.app_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.app_id);
    }
    if (null == this.appname) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, appname);
    }
    if (null == this.review_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.review_id);
    }
    if (null == this.language) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, language);
    }
    if (null == this.review) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, review);
    }
    if (null == this.time_date_created) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.time_date_created.getTime());
    __dataOut.writeInt(this.time_date_created.getNanos());
    }
    if (null == this.time_date_updated) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.time_date_updated.getTime());
    __dataOut.writeInt(this.time_date_updated.getNanos());
    }
    if (null == this.recommended) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.recommended);
    }
    if (null == this.votes_helpful) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.votes_helpful);
    }
    if (null == this.votes_funny) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.votes_funny);
    }
    if (null == this.weighted_vote_score) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.weighted_vote_score);
    }
    if (null == this.comment_count) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.comment_count);
    }
    if (null == this.steam_purchase) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.steam_purchase);
    }
    if (null == this.received_for_free) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.received_for_free);
    }
    if (null == this.written_during_early_access) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.written_during_early_access);
    }
    if (null == this.author_steamid) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.author_steamid);
    }
    if (null == this.playtime_forever) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.playtime_forever);
    }
    if (null == this.playtime_last_two_weeks) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.playtime_last_two_weeks);
    }
    if (null == this.playtime_at_review) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.playtime_at_review);
    }
    if (null == this.last_played) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.last_played.getTime());
    __dataOut.writeInt(this.last_played.getNanos());
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(id==null?"null":"" + id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(app_id==null?"null":"" + app_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(appname==null?"null":appname, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(review_id==null?"null":"" + review_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(language==null?"null":language, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(review==null?"null":review, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(time_date_created==null?"null":"" + time_date_created, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(time_date_updated==null?"null":"" + time_date_updated, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(recommended==null?"null":"" + recommended, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(votes_helpful==null?"null":"" + votes_helpful, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(votes_funny==null?"null":"" + votes_funny, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(weighted_vote_score==null?"null":"" + weighted_vote_score, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(comment_count==null?"null":"" + comment_count, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(steam_purchase==null?"null":"" + steam_purchase, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(received_for_free==null?"null":"" + received_for_free, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(written_during_early_access==null?"null":"" + written_during_early_access, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(author_steamid==null?"null":"" + author_steamid, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(playtime_forever==null?"null":"" + playtime_forever, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(playtime_last_two_weeks==null?"null":"" + playtime_last_two_weeks, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(playtime_at_review==null?"null":"" + playtime_at_review, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(last_played==null?"null":"" + last_played, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(id==null?"null":"" + id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(app_id==null?"null":"" + app_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(appname==null?"null":appname, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(review_id==null?"null":"" + review_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(language==null?"null":language, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(review==null?"null":review, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(time_date_created==null?"null":"" + time_date_created, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(time_date_updated==null?"null":"" + time_date_updated, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(recommended==null?"null":"" + recommended, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(votes_helpful==null?"null":"" + votes_helpful, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(votes_funny==null?"null":"" + votes_funny, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(weighted_vote_score==null?"null":"" + weighted_vote_score, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(comment_count==null?"null":"" + comment_count, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(steam_purchase==null?"null":"" + steam_purchase, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(received_for_free==null?"null":"" + received_for_free, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(written_during_early_access==null?"null":"" + written_during_early_access, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(author_steamid==null?"null":"" + author_steamid, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(playtime_forever==null?"null":"" + playtime_forever, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(playtime_last_two_weeks==null?"null":"" + playtime_last_two_weeks, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(playtime_at_review==null?"null":"" + playtime_at_review, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(last_played==null?"null":"" + last_played, delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.id = null; } else {
      this.id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.app_id = null; } else {
      this.app_id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.appname = null; } else {
      this.appname = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.review_id = null; } else {
      this.review_id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.language = null; } else {
      this.language = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.review = null; } else {
      this.review = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.time_date_created = null; } else {
      this.time_date_created = java.sql.Timestamp.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.time_date_updated = null; } else {
      this.time_date_updated = java.sql.Timestamp.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.recommended = null; } else {
      this.recommended = BooleanParser.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.votes_helpful = null; } else {
      this.votes_helpful = Long.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.votes_funny = null; } else {
      this.votes_funny = Long.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.weighted_vote_score = null; } else {
      this.weighted_vote_score = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.comment_count = null; } else {
      this.comment_count = Long.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.steam_purchase = null; } else {
      this.steam_purchase = BooleanParser.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.received_for_free = null; } else {
      this.received_for_free = BooleanParser.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.written_during_early_access = null; } else {
      this.written_during_early_access = BooleanParser.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.author_steamid = null; } else {
      this.author_steamid = Long.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.playtime_forever = null; } else {
      this.playtime_forever = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.playtime_last_two_weeks = null; } else {
      this.playtime_last_two_weeks = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.playtime_at_review = null; } else {
      this.playtime_at_review = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.last_played = null; } else {
      this.last_played = java.sql.Timestamp.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.id = null; } else {
      this.id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.app_id = null; } else {
      this.app_id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.appname = null; } else {
      this.appname = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.review_id = null; } else {
      this.review_id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.language = null; } else {
      this.language = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.review = null; } else {
      this.review = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.time_date_created = null; } else {
      this.time_date_created = java.sql.Timestamp.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.time_date_updated = null; } else {
      this.time_date_updated = java.sql.Timestamp.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.recommended = null; } else {
      this.recommended = BooleanParser.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.votes_helpful = null; } else {
      this.votes_helpful = Long.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.votes_funny = null; } else {
      this.votes_funny = Long.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.weighted_vote_score = null; } else {
      this.weighted_vote_score = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.comment_count = null; } else {
      this.comment_count = Long.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.steam_purchase = null; } else {
      this.steam_purchase = BooleanParser.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.received_for_free = null; } else {
      this.received_for_free = BooleanParser.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.written_during_early_access = null; } else {
      this.written_during_early_access = BooleanParser.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.author_steamid = null; } else {
      this.author_steamid = Long.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.playtime_forever = null; } else {
      this.playtime_forever = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.playtime_last_two_weeks = null; } else {
      this.playtime_last_two_weeks = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.playtime_at_review = null; } else {
      this.playtime_at_review = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.last_played = null; } else {
      this.last_played = java.sql.Timestamp.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    reviews o = (reviews) super.clone();
    o.time_date_created = (o.time_date_created != null) ? (java.sql.Timestamp) o.time_date_created.clone() : null;
    o.time_date_updated = (o.time_date_updated != null) ? (java.sql.Timestamp) o.time_date_updated.clone() : null;
    o.last_played = (o.last_played != null) ? (java.sql.Timestamp) o.last_played.clone() : null;
    return o;
  }

  public void clone0(reviews o) throws CloneNotSupportedException {
    o.time_date_created = (o.time_date_created != null) ? (java.sql.Timestamp) o.time_date_created.clone() : null;
    o.time_date_updated = (o.time_date_updated != null) ? (java.sql.Timestamp) o.time_date_updated.clone() : null;
    o.last_played = (o.last_played != null) ? (java.sql.Timestamp) o.last_played.clone() : null;
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new HashMap<String, Object>();
    __sqoop$field_map.put("id", this.id);
    __sqoop$field_map.put("app_id", this.app_id);
    __sqoop$field_map.put("appname", this.appname);
    __sqoop$field_map.put("review_id", this.review_id);
    __sqoop$field_map.put("language", this.language);
    __sqoop$field_map.put("review", this.review);
    __sqoop$field_map.put("time_date_created", this.time_date_created);
    __sqoop$field_map.put("time_date_updated", this.time_date_updated);
    __sqoop$field_map.put("recommended", this.recommended);
    __sqoop$field_map.put("votes_helpful", this.votes_helpful);
    __sqoop$field_map.put("votes_funny", this.votes_funny);
    __sqoop$field_map.put("weighted_vote_score", this.weighted_vote_score);
    __sqoop$field_map.put("comment_count", this.comment_count);
    __sqoop$field_map.put("steam_purchase", this.steam_purchase);
    __sqoop$field_map.put("received_for_free", this.received_for_free);
    __sqoop$field_map.put("written_during_early_access", this.written_during_early_access);
    __sqoop$field_map.put("author_steamid", this.author_steamid);
    __sqoop$field_map.put("playtime_forever", this.playtime_forever);
    __sqoop$field_map.put("playtime_last_two_weeks", this.playtime_last_two_weeks);
    __sqoop$field_map.put("playtime_at_review", this.playtime_at_review);
    __sqoop$field_map.put("last_played", this.last_played);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("id", this.id);
    __sqoop$field_map.put("app_id", this.app_id);
    __sqoop$field_map.put("appname", this.appname);
    __sqoop$field_map.put("review_id", this.review_id);
    __sqoop$field_map.put("language", this.language);
    __sqoop$field_map.put("review", this.review);
    __sqoop$field_map.put("time_date_created", this.time_date_created);
    __sqoop$field_map.put("time_date_updated", this.time_date_updated);
    __sqoop$field_map.put("recommended", this.recommended);
    __sqoop$field_map.put("votes_helpful", this.votes_helpful);
    __sqoop$field_map.put("votes_funny", this.votes_funny);
    __sqoop$field_map.put("weighted_vote_score", this.weighted_vote_score);
    __sqoop$field_map.put("comment_count", this.comment_count);
    __sqoop$field_map.put("steam_purchase", this.steam_purchase);
    __sqoop$field_map.put("received_for_free", this.received_for_free);
    __sqoop$field_map.put("written_during_early_access", this.written_during_early_access);
    __sqoop$field_map.put("author_steamid", this.author_steamid);
    __sqoop$field_map.put("playtime_forever", this.playtime_forever);
    __sqoop$field_map.put("playtime_last_two_weeks", this.playtime_last_two_weeks);
    __sqoop$field_map.put("playtime_at_review", this.playtime_at_review);
    __sqoop$field_map.put("last_played", this.last_played);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if (!setters.containsKey(__fieldName)) {
      throw new RuntimeException("No such field:"+__fieldName);
    }
    setters.get(__fieldName).setField(__fieldVal);
  }

}
