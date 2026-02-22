const publish = [{ path: '@semantic-release/github' }];

const analyzeCommits = [
    {
        path: '@semantic-release/commit-analyzer',
        releaseRules: [
            { type: "feat", release: "minor" },
            { type: "fix", release: "patch" },
            { type: "breaking", release: "major" },
            { type: "refactor", release: "patch" },
            { type: "chore", release: "patch" },
            { type: "docs", release: "patch" },
        ]
    }
];

const generateNotes = [
    {
        path: '@semantic-release/release-notes-generator',
        preset: 'conventionalcommits',
        presetConfig: {
            types: [
                { type: "breaking", section: "Breaking Changes" },
                { type: "feat", section: "Features" },
                { type: "fix", section: "Bug Fixes" },
                { type: "chore", section: "Chore" },
                { type: "refactor", hidden: true },
                { type: "docs", hidden: true },
                { type: "doc", hidden: true },
                { type: "style", hidden: true },
                { type: "perf", hidden: true },
                { type: "test", hidden: true }
            ]
        },
        writerOpts: {
            groupBy: "type",
            commitGroupsSort: ["breaking", "feat", "fix", "chore"],
            commitsSort: "header"
        }
    }
];

const prepare = [
    {
        path: '@semantic-release/changelog',
        changelogFile: 'CHANGELOG.md'
    },
    {
        path: '@semantic-release/exec',
        verifyReleaseCmd: './update-version.sh $BRANCH_NAME ${nextRelease.version}'
    }
];

const config = {
    branches: [
        'main',
        { name: 'develop', prerelease: 'SNAPSHOT' }
    ],
    analyzeCommits,
    generateNotes,
    prepare,
    publish
};

module.exports = config;