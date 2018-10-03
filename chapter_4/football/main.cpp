/* @BEGIN_OF_SOURCE_CODE */
#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

struct Team
{
    string name;
    int points = 0;
    int games = 0;
    int wins = 0;
    int losses = 0;
    int ties = 0;
    int goals = 0;
    int goal_diff = 0;
    int goals_given = 0;
};

bool compareTeam(const Team &a, const Team &b)
{
    if (a.points == b.points)
    {
        if (a.wins == b.wins)
        {
            if (a.goal_diff == b.goal_diff)
            {
                if (a.goals == b.goals)
                {
                    if (a.games == b.games)
                    {
                        string astring = a.name;
                        string bstring = b.name;
                        for(int i = 0; i < a.name.size(); i++)
                            astring[i] = tolower(a.name[i]);
                        for(int i = 0; i < b.name.size(); i++)
                            bstring[i] = tolower(b.name[i]);
                        return astring < bstring;
                    }
                    return a.games < b.games ;
                }
                return b.goals < a.goals;
            }
            return b.goal_diff < a.goal_diff;
        }
        return b.wins < a.wins;
    }
    return b.points < a.points;
}
//takes a map of teams as reference and parses the game data to update team standing
void parseInput(map<string, Team> &key)
{
    string input;
    getline(cin, input);
    //parse the string input
    string team1, team2, delimiter1, delimiter2;
    int score1, score2;
    delimiter1 = "#";
    delimiter2 = "@";
    team1 = input.substr(0, input.find(delimiter1));
    string temp;
    int length = input.length();
    temp = input.substr(input.find(delimiter2), input[length-1]);
    team2 = temp.substr(temp.find(delimiter1)+1, temp.length() - 1);
    score1 = stoi(input.substr(input.find(delimiter1) + 1, input.find(delimiter2)));
    score2 = stoi(input.substr(input.find(delimiter2) + 1, input.find(delimiter2)));
    //update team data
    key[team1].games++; key[team1].goals+=score1; key[team1].goals_given+=score2;
    key[team1].goal_diff+= (score1 - score2);
    key[team2].games++; key[team2].goals+=score2; key[team2].goals_given+=score1;
    key[team2].goal_diff+= (score2 - score1);
    //tie
    if (score1 == score2)
    {
        key[team1].ties++;
        key[team1].points++;
        key[team2].ties++;
        key[team2].points++;
    }
    //team 1 is winner
    else if (score1 > score2)
    {
        key[team1].wins++;
        key[team1].points+=3;
        key[team2].losses++;
    }
    //team 2 is winner
    else
    {
        key[team1].losses++;
        key[team2].points+=3;
        key[team2].wins++;
    }

}

int main()
{
    int cases;
    cin >> cases;
    //ignore newline char
    cin.ignore();
    for (int i = 0; i < cases; i++)
    {
        string tournament_name;
        getline(cin, tournament_name);
        int num_teams;
        cin >> num_teams;
        //ignore newline char
        cin.ignore();
        vector<Team> team_vector;
        map<string, Team> key;
        //get a map of teams by team name
        for (int j = 0; j < num_teams; j++)
        {
            string team_name;
            getline(cin, team_name);
            Team t;
            t.name = team_name;
            key[team_name] = t;
        }
        int num_games = 0;
        cin >> num_games;
        cin.ignore();
        for (int j = 0; j < num_games; j++)
        {
            parseInput(key);
        }
        //transfer from key to vector
        for(auto elem : key)
            team_vector.push_back(elem.second);
        //sort team_vector
        sort(team_vector.begin(), team_vector.end(), compareTeam);
        //output pretty
        cout << tournament_name << endl;
        for (int j=0; j < num_teams; j++) {
            Team team = team_vector[j];
            cout << (j+1) <<  ") " << team.name << " " << team.points << "p, " << team.games << "g (" <<
                           team.wins << "-" << team.ties << "-" << team.losses << "), " << team.goal_diff << "gd (" << team.goals <<
                           "-" << team.goals_given << ")" << endl;
        }
        if (i < cases - 1)
            cout << endl;

    }

    return 0;
}
/* @JUDGE_ID: 979449 10194 C++ "Football" */
/* @END_OF_SOURCE_CODE */
