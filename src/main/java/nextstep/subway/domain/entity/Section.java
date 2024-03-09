package nextstep.subway.domain.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="line_id")
    private Line line;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="up_station_id")
    private Station upStation;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="down_station_id")
    private Station downStation;

    private int distance;

    private int duration;

    public Section(Line line, Station upStation, Station downStation, int distance, int duration) {
        this.line = line;
        this.upStation = upStation;
        this.downStation = downStation;
        this.distance = distance;
        this.duration = duration;
    }

    public Section(Station upStation, Station downStation, int distance, int duration) {
        this.upStation = upStation;
        this.downStation = downStation;
        this.distance = distance;
        this.duration = duration;
    }

    public List<Station> getStations() {
        List<Station> stations = new ArrayList<>();
        stations.add(this.getUpStation());
        stations.add(this.getDownStation());
        return stations;
    }

    public boolean isSameAsUpStation(Station station) {
        return this.getUpStation().equals(station);
    }

    public boolean isSameAsDwonStation(Station station) {
        return this.getDownStation().equals(station);
    }

    public int getValueByType(PathSearchType type) {
        if (type == PathSearchType.DISTANCE) return distance;
        return duration;
    }
}
