The KLEAR project welcomes contributions in a variety of forms.
This document contains information a few of the ways you can contribute to the KLEAR project.
Please also review our [Governance model](https://github.com/KLEAR/KLEAR/blob/master/GOVERNANCE.md)

## Provide peer user support

We welcome users to the [KLEAR forum](https://forum.klear.org/) to ask questions and request assistance.
If you can help answer questions in your area of expertise, it would be a benefit to the community.

If a forum discussion determines there is a bug in KLEAR or a new feature is identified,
we welcome bug reports and feature requests. Please search the [issue tracker](https://github.com/KLEAR/KLEAR/issues) first to make sure
the bug / feature hasn't already been added. Note: the development team principally works from the issue
tracker, so anything not included there risks getting lost.

## Promote KLEAR

Promoting KLEAR is a great way to give back. Did you write a tutorial or article about KLEAR on your blog or site?
Are you organizing a workshop or presentation for KLEAR in your city? Let us, and the community, know via our [forum](https://forum.klear.org/) or social media.

## Contribute translations

We want KLEAR to be available in as many languages as possible to serve
the biggest community of users. You can help us [translate KLEAR](https://docs.klear.org/technical-reference/translating-ui) into languages you are fluent in [via Weblate](https://hosted.weblate.org/engage/klear/?utm_source=widget).
Although we have the beginnings of translations for many languages, only a few are complete and popular languages
like Spanish, Brazilian Portuguese, and French could use help.

## Contribute documentation

When browsing our [user manual](https://klear.org/docs/) or other documentation, feel free to use the edit button to suggest improvements.
For large changes, you might want to first discuss your proposed changes on the forum and then [prepare your changes locally](https://klear.org/docs/technical-reference/documentation-contributions).

##  Contribute code 

You can contribute code in various ways:
- Fix bugs or implement new features. Follow [our guide towards your first code contribution](https://klear.org/docs/technical-reference/code-contributions)
- Improve test coverage. Much of our code was originally written without tests, so help on this front is very much appreciated.
- Develop an KLEAR extension
- Develop a reconciliation service

All developers including new distributions and plugin developers are invited to leverage the following KLEAR project management areas.
- the [official documentation](https://klear.org/docs/) for shared documentation between both user docs and [technical reference](https://docs.klear.org/technical-reference/contributing)
- the [developer forum](https://forum.klear.org/c/dev/8) for technical questions, new feature development and anything code related. We invite you to share your idea there first. Someone may be able to point out to existing development saving you hours of research and development.
- the [issue tracker](https://github.com/KLEAR/KLEAR/issues) for requesting new features and bug reports.
- [Gitter Chat](https://gitter.im/KLEAR/KLEAR) (only occasionally monitored)

### How to submit PR's (pull requests), patches, and bug fixes

All code changes are made via GitHub Pull Requests which are reviewed before merging, even those by core committers.

If you are unfamiliar with git, GitHub, or open source development, please see [our guide towards your first code contribution](https://klear.org/docs/technical-reference/code-contributions).

- If you are looking for something to work on, please see our [issue list](https://github.com/KLEAR/KLEAR/issues). We have a separate tag for [Good First Issues](https://github.com/KLEAR/KLEAR/issues?q=is%3Aopen+is%3Aissue+label%3A%22Good+First+Issue%22).

- create a branch named with the issue number and a brief description
- avoid changes unrelated to fixing the issue
- create unit and/or end-to-end tests which cover the bug fix or new feature
- run `./refine lint` before submitting your PR (CI will fail if lint fails)
- make sure all tests are green before submitting your PR
- we attempt to prioritize PR reviews, but please be patient

### New functionality via extensions

KLEAR supports a plugin architecture to extend its functionality. You can find more information on how to write
an extension on our [website](https://klear.org/docs/technical-reference/writing-extensions).
Giuliano Tortoreto also wrote separate documentation detailing how to build an extension for KLEAR.
[PDF](https://github.com/giTorto/KLEARExtensionDoc/blob/master/main.pdf) and [LaTeX](https://github.com/giTorto/KLEARExtensionDoc/) versions are available. It dates from 2014, but still contains good information.

If you want your extension included in the [list of extensions](https://klear.org/extensions) advertised on klear.org,
please submit a pull request on the download page, please edit [this file](https://github.com/KLEAR/klear.org/blob/master/src/pages/extensions.md).
